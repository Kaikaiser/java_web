package interceptor;

import com.alibaba.fastjson.JSONObject;
import com.practice.springbootmybatisexampleproject.pojo.Result;
import com.practice.springbootmybatisexampleproject.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override // 预处理 控制器方法执行前调用 返回true放行  false拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        HttpServletRequest req = request;
        HttpServletResponse resp = response;

        // 获取请求url
        String requestURI = req.getRequestURI().toString();
        log.info("请求路径：{}", requestURI);

        // 判断是否存在login路径 登录相关路径放行(login/register)
        if (requestURI.contains("/login") || requestURI.contains("/register")) {
            filterChain.doFilter(req, resp);
            return;
        }

        // 判断获取的令牌是否存在 不存在返回错误结果
        String token = req.getHeader("token");
        if (!StringUtils.hasLength(token)) {
            log.error("token为空");
            Result<String> error = Result.error("NOT_LOGIN");
            // 手动转换 对象——json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        // 解析token 解析失败 再返回错误
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) { // 解析失败
            e.printStackTrace();
            log.error("token解析失败");
            Result<String> error = Result.error("NOT_LOGIN");
            // 手动转换 对象——json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }


        // 放行
        log.info("token解析成功,放行");
        filterChain.doFilter(servletRequest,servletResponse);
        return true;
    }

    @Override // 后处理 控制器方法执行后调用  可以对模型数据或视图进行修改
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override // 完成处理 控制器方法执行完成后调用  可以进行资源清理
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");

    }
}
