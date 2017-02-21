package projects.com.kamboj.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.Bind;
import butterknife.ButterKnife;
import projects.com.kamboj.R;


public class WebViw extends AppCompatActivity {


    @Bind(R.id.webView)
    WebView urlWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        Fresco.initialize(this);
        ButterKnife.bind(this);

        urlWebView.setWebViewClient(new AppWebViewClients());
        urlWebView.getSettings().setJavaScriptEnabled(true);
        urlWebView.getSettings().setUseWideViewPort(true);
        urlWebView.loadUrl("https://docs.google.com/gview?embedded=true&url="
                + "http://WCC10.zonetail.nexusonline.ca/LibraryDocument/Link/636231711155051415_607b3ecc3e9862e6_18173");

    }

    public class AppWebViewClients extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);

        }
    }


}
