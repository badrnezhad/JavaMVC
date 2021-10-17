package net.holosen.mvcapplication.controllers;

import net.holosen.mvcapplication.models.User;
import net.holosen.mvcapplication.views.ILoginView;

public class LoginController implements ILoginController {
    private ILoginView view;

    public LoginController(ILoginView view) {
        this.view = view;
    }

    @Override
    public void doLogin(User user) {
        if (user == null) {
            view.onError("Please fill user information.");
            return;
        }
        if (!user.isValid()) {
            view.onError("Please enter username and password(min len = 8).");
            return;
        }
        //TODO: store to db + Call login api + get token + store token to db
        view.onSuccess();
    }
}
