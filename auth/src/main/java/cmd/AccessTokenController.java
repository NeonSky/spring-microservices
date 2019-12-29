package cmd;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class AccessTokenController {

    @GetMapping("/")
    public String home() {
        return "Welcome! This endpoint is public";
    }

    @GetMapping("/token")
    public OAuth2AccessToken accessToken(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
        return authorizedClient.getAccessToken();
    }

    @GetMapping("/user")
    public OAuth2User index(@AuthenticationPrincipal OAuth2User oauth2User) {
        return oauth2User;
    }

    @GetMapping("/login")
    public ModelAndView login(HttpServletRequest request, Model model, @RequestParam() String redirect_url) {
        request.getSession().setAttribute("url_prior_login", redirect_url);
        return new ModelAndView("redirect:/oauth2/authorization/google");
    }

}
