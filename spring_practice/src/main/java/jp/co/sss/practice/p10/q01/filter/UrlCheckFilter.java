package jp.co.sss.practice.p10.q01.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UrlCheckFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// リクエストされたURLを取得
		String requestURL = request.getRequestURL().toString();

		// URLに"filter"が含まれているか判定
		if (requestURL.contains("filter")) {

			// 取得したURLをリクエストスコープに保存
			request.setAttribute("requestURL", requestURL);

			// 取得したURLをコンソールに出力
			System.out.println(requestURL);

			// URLの末尾が"abc"の場合、/practice/filter/xyz にリダイレクト
			if (requestURL.endsWith("abc")) {
				response.sendRedirect(request.getContextPath() + "/filter/xyz");
				return;
			}
		}

		// 処理を継続
		chain.doFilter(request, response);
	}
}
