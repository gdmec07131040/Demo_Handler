package cn.edu.gdmec.s07131040.demo_handler;

import android.os.Bundle;
import android.os.Handler;

import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView imageView;
	private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        imageView = (ImageView) findViewById(R.id.imageView);
        handler = new Handler(){
        	@Override
        	public void handleMessage(Message msg) {
        		int imageResource=(Integer) msg.obj;
        		imageView.setImageResource(imageResource);
        	}
        	
        };

    }
    public void doClick(View v){
    	//工作线程中执行下载
    	new Thread(){
    		public void run(){
    			try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			Message msg = Message.obtain();
    			msg.obj = R.drawable.ic_launcher;
    			//子线程中将图片发送到主线程中
    			handler.sendMessage(msg);
    			
    			
    		}
    	}.start();
    	
    }


  

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
