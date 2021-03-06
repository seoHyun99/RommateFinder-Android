package guilhermeborgesbastos.com.br.tindercardslide.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import guilhermeborgesbastos.com.br.tindercardslide.ContentActivity;
import guilhermeborgesbastos.com.br.tindercardslide.MainActivity;
import guilhermeborgesbastos.com.br.tindercardslide.R;
import guilhermeborgesbastos.com.br.tindercardslide.util.LaunchCardListener;
import guilhermeborgesbastos.com.br.tindercardslide.util.SlideLaunchAdapterView;
import guilhermeborgesbastos.com.br.tindercardslide.pojos.Notification;

/**
 * Created by Guilherme Borges Bastos on 02/17/2016.
 * guilhermeborgesbastos@gmail.com
 */

public class SlideCardFragment extends Fragment implements LaunchCardListener.ActionDownInterface {

    private static final Object API = "http://findme.meucomercioeletronico.com/";
    public static MyAppAdapter myAppAdapter;
    public static ViewHolder viewHolder;
    private SlideLaunchAdapterView flingContainer;
    public String token;
    View rootView;
    private TextView recList;
    public  List<Notification> recordSet;

    public SlideCardFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            token = getArguments().getString("user_id");
        }

        //create new instance on POJOS Notification
        recordSet = new ArrayList<>();

        for (int i=0; i<100 ; i++) {
            Notification notification1 = new Notification();
            notification1.setNome("전지현");
            notification1.setSobrenome("");
            notification1.setFoto(R.drawable.jeonjihyeon);
            notification1.setNome_cidade("36세");
            notification1.setNome_estado("선생님");
            recordSet.add(notification1);

            Notification notification3 = new Notification();
            notification3.setNome("수지");
            notification3.setSobrenome("");
            notification3.setFoto(R.drawable.suji);
            notification3.setNome_cidade("23세");
            notification3.setNome_estado("대학생");
            recordSet.add(notification3);

            Notification notification2 = new Notification();
            notification2.setNome("김고은");
            notification2.setSobrenome("");
            notification2.setFoto(R.drawable.goeun);
            notification2.setNome_cidade("26세");
            notification2.setNome_estado("디자이너");
            recordSet.add(notification2);

            Notification notification4 = new Notification();
            notification4.setNome("설현");
            notification4.setSobrenome("");
            notification4.setFoto(R.drawable.seolhyun);
            notification4.setNome_cidade("22세");
            notification4.setNome_estado("모델");
            recordSet.add(notification4);
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        if(rootView == null ){
            rootView = inflater.inflate(R.layout.notification_frag, container, false);
        }



        init();

        return rootView;
    }


    private void init() {


        flingContainer = (SlideLaunchAdapterView) rootView.findViewById(R.id.frame);
        myAppAdapter = new MyAppAdapter(recordSet);
        flingContainer.setAdapter(myAppAdapter);

        flingContainer.setFlingListener(new SlideLaunchAdapterView.onFlingListener() {

            @Override
            public void removeFirstObjectInAdapter() {
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                recordSet.remove(0);
                myAppAdapter.notifyDataSetChanged();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                recordSet.remove(0);
                myAppAdapter.notifyDataSetChanged();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        flingContainer.setOnItemClickListener(new SlideLaunchAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                myAppAdapter.notifyDataSetChanged();
                Intent intent = new Intent(getActivity(), ContentActivity.class);
                startActivity(intent);

            }
        });

    }

    public  void setData(List<Notification> _recordSet){
        if(recordSet == null) {
            recordSet = _recordSet;
        }
    }

    @Override
    public void onActionDownPerform() {
        Log.e("action", "bingo");
    }

    public final class ViewHolder {

        public FrameLayout background;
        public LinearLayout card_3;
        public LinearLayout card_2;
        public TextView DataText;
        public TextView estado;
        public TextView cidade;
        public TextView titulo;
        public CircularImageView friendPhoto;
        public int tipo;
        public Button btnIgnore;
        public Button btnAccept;
        public LinearLayout group;

        //controle para esconder as sub-cartas
        public void hideBackground(boolean b, int i) {

            int current_card_num = recordSet.size();

            if(b){

                if(current_card_num >= 3){
                    card_2.setAlpha(1);
                    card_2.setVisibility(View.VISIBLE);
                    card_3.setAlpha(1);
                    card_3.setVisibility(View.VISIBLE);
                } else if(current_card_num == 2){
                    card_3.setAlpha(0);
                    card_3.setVisibility(View.GONE);
                    card_2.setAlpha(1);
                    card_2.setVisibility(View.VISIBLE);
                } else {
                    card_3.setAlpha(0);
                    card_3.setVisibility(View.GONE);
                    card_2.setAlpha(0);
                    card_2.setVisibility(View.GONE);
                }

            } else {
                background.setAlpha(1);
                background.setVisibility(View.VISIBLE);
            }
        }
    }

    public class MyAppAdapter extends BaseAdapter {


        public List<Notification> parkingList;

        private MyAppAdapter(List<Notification> apps) {
            this.parkingList = apps;
        }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;


            if (rowView == null) {

                LayoutInflater inflater = getActivity().getLayoutInflater();
                rowView = inflater.inflate(R.layout.item_card, parent, false);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.DataText = (TextView) rowView.findViewById(R.id.user_name);
                viewHolder.friendPhoto = (CircularImageView) rowView.findViewById(R.id.friendPhoto);
                viewHolder.background = (FrameLayout) rowView.findViewById(R.id.background);
                viewHolder.card_3 = (LinearLayout) rowView.findViewById(R.id.card_3);
                viewHolder.card_2 = (LinearLayout) rowView.findViewById(R.id.card_2);
                viewHolder.estado = (TextView) rowView.findViewById(R.id.estado);
                viewHolder.cidade = (TextView) rowView.findViewById(R.id.cidade);
                viewHolder.titulo = (TextView) rowView.findViewById(R.id.titulo);
                viewHolder.btnIgnore = (Button) rowView.findViewById(R.id.btnIgnore);
                viewHolder.btnAccept = (Button) rowView.findViewById(R.id.btnAccept);
                viewHolder.group = (LinearLayout) rowView.findViewById(R.id.group);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.hideBackground(true, 1);

           /* //TODO : 터치

            viewHolder.group.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if ( event.getAction() == MotionEvent.ACTION_UP) {
                        Intent intent = new Intent(getActivity(), ContentActivity.class);
                        startActivity(intent);
                    }
                    return true;
                }
            });*/




            viewHolder.btnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flingContainer.getTopCardListener().selectRight();
                }
            });


            viewHolder.btnIgnore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    flingContainer.getTopCardListener().selectLeft();

                }
            });

            viewHolder.tipo = parkingList.get(position).getType();

            // 1 friendship  /  2 location
            if(viewHolder.tipo == 1){
                viewHolder.titulo.setText("Pedido de Amizade");
                viewHolder.btnAccept.setText("Aceitar");
                viewHolder.btnIgnore.setText("Recusar");
            } else if(viewHolder.tipo == 2){
                viewHolder.titulo.setText("Pedido de Localização");
                viewHolder.btnAccept.setText("Visualizar");
                viewHolder.btnIgnore.setText("Ignorar");
            }

            viewHolder.DataText.setText(parkingList.get(position).getNome() + " " + parkingList.get(position).getSobrenome());
            viewHolder.cidade.setText(parkingList.get(position).getNome_cidade());
            viewHolder.estado.setText(parkingList.get(position).getNome_estado());

            //user photo
            int photo = parkingList.get(position).getFoto();
            String strPhoto = API + "/" + photo;

            if (strPhoto != null) {

                Picasso.with(getActivity())
                        .load(photo)
                        .placeholder(R.drawable.avatar_default)
                        .fit()
                        .centerCrop()
                        .into(viewHolder.friendPhoto);

            }


            return rowView;
        }
    }

}
