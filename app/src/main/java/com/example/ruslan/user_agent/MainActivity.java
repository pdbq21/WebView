package com.example.ruslan.user_agent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button_sbm;
    private EditText url_text;
    private WebView browser;

    private String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openUrl();
    }

    public void openUrl() {
        button_sbm =(Button)findViewById(R.id.button);
        url_text =(EditText)findViewById(R.id.editText);
        browser = (WebView)findViewById(R.id.webView);

        browser.getSettings().setUserAgentString(userAgent);
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        browser.setWebViewClient(new myBrowser());

        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = url_text.getText().toString();
                        //browser.getSettings().setLoadsImagesAutomatically(true);
                        //browser.getSettings().setJavaScriptEnabled(true);
                        //browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

                        browser.loadUrl(url);
                    }
                }
        );


    }

    private class myBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

}
