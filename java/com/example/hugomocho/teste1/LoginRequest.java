package com.example.hugomocho.teste1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hugo Mochão on 20/07/2017.
 */

public class LoginRequest extends StringRequest{


    private static final String LOGIN_REQUEST_URL = "http://bossgarfield21.000webhostapp.com/login.php";
    private Map<String, String> params;

    public LoginRequest(String nomeUsuario, String password, Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("nomeUsuario", nomeUsuario);
        params.put("password", password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
