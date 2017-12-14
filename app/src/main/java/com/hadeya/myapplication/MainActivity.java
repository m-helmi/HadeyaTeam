package com.hadeya.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();

    Button btn_connect;
    TextView tv_json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_connect=(Button)findViewById(R.id.btn_connect);
        tv_json=(TextView)findViewById(R.id.tv_json);
        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJSON getJSON=new GetJSON();
                getJSON.execute();
            }
        });
    }


    private class GetJSON extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {
            String ss="";
            Request request = new Request.Builder()
                    .url("http://albukhary.zagel-app.com/api/manager2/Get_Nur_About/en?id=3")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                ss= response.body().string();
            }catch (Exception e){}
            return ss;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            tv_json.setText(s);
        }
    }


}
