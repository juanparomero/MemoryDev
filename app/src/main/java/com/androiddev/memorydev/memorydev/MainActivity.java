package com.androiddev.memorydev.memorydev;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author J. P. Romero
 * @version 1.0
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, imgCapturada;
    Button jugar, salir;
    TextView idMensaje;
    int cap1, cap2, control1, control2, contador;

//--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView)findViewById(R.id.imageView1);
        img2 = (ImageView)findViewById(R.id.imageView2);
        img3 = (ImageView)findViewById(R.id.imageView3);
        img4 = (ImageView)findViewById(R.id.imageView4);
        img5 = (ImageView)findViewById(R.id.imageView5);
        img6 = (ImageView)findViewById(R.id.imageView6);
        img7 = (ImageView)findViewById(R.id.imageView7);
        img8 = (ImageView)findViewById(R.id.imageView8);
        img9 = (ImageView)findViewById(R.id.imageView9);
        img10 = (ImageView)findViewById(R.id.imageView10);
        img11 = (ImageView)findViewById(R.id.imageView11);
        img12 = (ImageView)findViewById(R.id.imageView12);

        jugar = (Button)findViewById(R.id.jugar);
        salir = (Button)findViewById(R.id.salir);

        idMensaje = (TextView)findViewById(R.id.contador);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        img9.setOnClickListener(this);
        img10.setOnClickListener(this);
        img11.setOnClickListener(this);
        img12.setOnClickListener(this);
        jugar.setOnClickListener(this);
        salir.setOnClickListener(this);

        disable();
        contador=0;
    }
    //--------------------------------------------------------------------------------------------------
    public void disable(){
        img1.setEnabled(false);
        img2.setEnabled(false);
        img3.setEnabled(false);
        img4.setEnabled(false);
        img5.setEnabled(false);
        img6.setEnabled(false);
        img7.setEnabled(false);
        img8.setEnabled(false);
        img9.setEnabled(false);
        img10.setEnabled(false);
        img11.setEnabled(false);
        img12.setEnabled(false);
    }
    //--------------------------------------------------------------------------------------------------
    public void enable(){

        img1.setImageResource(R.mipmap.logo);
        img2.setImageResource(R.mipmap.logo);
        img3.setImageResource(R.mipmap.logo);
        img4.setImageResource(R.mipmap.logo);
        img5.setImageResource(R.mipmap.logo);
        img6.setImageResource(R.mipmap.logo);
        img7.setImageResource(R.mipmap.logo);
        img8.setImageResource(R.mipmap.logo);
        img9.setImageResource(R.mipmap.logo);
        img10.setImageResource(R.mipmap.logo);
        img11.setImageResource(R.mipmap.logo);
        img12.setImageResource(R.mipmap.logo);
        img1.setEnabled(true);
        img2.setEnabled(true);
        img3.setEnabled(true);
        img4.setEnabled(true);
        img5.setEnabled(true);
        img6.setEnabled(true);
        img7.setEnabled(true);
        img8.setEnabled(true);
        img9.setEnabled(true);
        img10.setEnabled(true);
        img11.setEnabled(true);
        img12.setEnabled(true);

    }
    //--------------------------------------------------------------------------------------------------
    public void compare(int idCurrentImage, int idBox, int idCurrentBox, final ImageView imgBox){
        if (cap1 == 0){//primera vez
            cap1 = idCurrentImage;
            control1 = idBox;
            imgCapturada = (ImageView)findViewById(control1);
        }else{//segunda vez
            if (control1 != idBox){//cajas distintas
                cap2 = idCurrentImage;
                if (cap2 != cap1){//imagenes distintas
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgCapturada.setImageResource(R.mipmap.logo);
                            imgBox.setImageResource(R.mipmap.logo);
                        }
                    },100);
                }else{//las imagenes son iguales
                    imgCapturada.setEnabled(false);
                    imgBox.setEnabled(false);
                    contador++;
                }
                cap2=0;
                cap1=0;
            }else{//los controles son iguales
                cap2=0; //para escoger otro control
            }
        }
    }
    //--------------------------------------------------------------------------------------------------
    public void cronometer(){
        new CountDownTimer(60000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                String seconds = String.valueOf(millisUntilFinished/1000);
                jugar.setEnabled(false);
                idMensaje.setText(seconds);
                if (contador == 6){
                    idMensaje.setText("¡¡Ganaste!!");
                    onFinish();
                }
            }

            @Override
            public void onFinish() {
                disable();
                jugar.setEnabled(true);
                if (contador != 6){
                    idMensaje.setText("¡¡Perdiste!!");
                }
                this.cancel();
            }
        }.start();
    }
    //--------------------------------------------------------------------------------------------------
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageView1:
                img1.setImageResource(R.mipmap.imagen1);
                compare(R.mipmap.imagen1, R.id.imageView1, v.getId(), img1);
                break;
            case R.id.imageView2:
                img2.setImageResource(R.mipmap.imagen2);
                compare(R.mipmap.imagen2, R.id.imageView2, v.getId(), img2);
                break;
            case R.id.imageView3:
                img3.setImageResource(R.mipmap.imagen3);
                compare(R.mipmap.imagen3, R.id.imageView3, v.getId(), img3);
                break;
            case R.id.imageView4:
                img4.setImageResource(R.mipmap.imagen4);
                compare(R.mipmap.imagen4, R.id.imageView4, v.getId(), img4);
                break;
            case R.id.imageView5:
                img5.setImageResource(R.mipmap.imagen5);
                compare(R.mipmap.imagen5, R.id.imageView5, v.getId(), img5);
                break;
            case R.id.imageView6:
                img6.setImageResource(R.mipmap.imagen6);
                compare(R.mipmap.imagen6, R.id.imageView6, v.getId(), img6);
                break;
            case R.id.imageView7:
                img7.setImageResource(R.mipmap.imagen1);
                compare(R.mipmap.imagen1, R.id.imageView7, v.getId(), img7);
                break;
            case R.id.imageView8:
                img8.setImageResource(R.mipmap.imagen2);
                compare(R.mipmap.imagen2, R.id.imageView8, v.getId(), img8);
                break;
            case R.id.imageView9:
                img9.setImageResource(R.mipmap.imagen3);
                compare(R.mipmap.imagen3, R.id.imageView9, v.getId(), img9);
                break;
            case R.id.imageView10:
                img10.setImageResource(R.mipmap.imagen4);
                compare(R.mipmap.imagen4, R.id.imageView10, v.getId(), img10);
                break;
            case R.id.imageView11:
                img11.setImageResource(R.mipmap.imagen5);
                compare(R.mipmap.imagen5, R.id.imageView11, v.getId(), img11);
                break;
            case R.id.imageView12:
                img12.setImageResource(R.mipmap.imagen6);
                compare(R.mipmap.imagen6, R.id.imageView12, v.getId(), img12);
                break;
            case R.id.jugar:
                enable();
                contador = 0;
                cronometer();
                break;
            case R.id.salir:
                finish();
                break;
        }
    }
    //--------------------------------------------------------------------------------------------------
}
//--------------------------------------------------------------------------------------------------