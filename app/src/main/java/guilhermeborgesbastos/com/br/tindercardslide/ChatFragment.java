package guilhermeborgesbastos.com.br.tindercardslide;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import guilhermeborgesbastos.com.br.tindercardslide.pojos.Notification;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {


    private ArrayList<MatchingListData> matchingListDatas = null;
    private ArrayList<MessageListData> messageListDatas = null;
    private MatchingViewAdapter matchingViewAdapter;
    private MessageListViewAdapter messageListViewAdapter;

    public ChatFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.fragment_chat, container, false);

        matchingListDatas = new ArrayList<>();
        messageListDatas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            MatchingListData matchingListData1 = new MatchingListData();
            matchingListData1.setName("전지현");
            matchingListData1.setPhoto(R.drawable.jeonjihyeon);
            matchingListDatas.add(matchingListData1);

            MatchingListData matchingListData2 = new MatchingListData();
            matchingListData2.setName("수지");
            matchingListData2.setPhoto(R.drawable.suji);
            matchingListDatas.add(matchingListData2);

            MatchingListData matchingListData3 = new MatchingListData();
            matchingListData3.setName("설현");
            matchingListData3.setPhoto(R.drawable.seolhyun);
            matchingListDatas.add(matchingListData3);

            MatchingListData matchingListData4 = new MatchingListData();
            matchingListData4.setName("김고은");
            matchingListData4.setPhoto(R.drawable.goeun);
            matchingListDatas.add(matchingListData4);
        }
        for (int i = 0; i < 5; i++) {
            MessageListData messageListData1 = new MessageListData();
            messageListData1.setName("김고은");
            messageListData1.setPhoto(R.drawable.goeun);
            messageListData1.setContent("안녕하세요~");
            messageListDatas.add(messageListData1);

            MessageListData messageListData2 = new MessageListData();
            messageListData2.setName("설현");
            messageListData2.setPhoto(R.drawable.seolhyun);
            messageListData2.setContent("안녕!");
            messageListDatas.add(messageListData2);

            MessageListData messageListData3 = new MessageListData();
            messageListData3.setName("수지");
            messageListData3.setPhoto(R.drawable.suji);
            messageListData3.setContent("ㅎㅎ");
            messageListDatas.add(messageListData3);

            MessageListData messageListData4 = new MessageListData();
            messageListData4.setName("전지현");
            messageListData4.setPhoto(R.drawable.jeonjihyeon);
            messageListData4.setContent("안녕하세요~");
            messageListDatas.add(messageListData4);
        }


        RecyclerView rv_matching_list = (RecyclerView) baseView.findViewById(R.id.rv_matching_list);
        rv_matching_list.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        matchingViewAdapter = new MatchingViewAdapter();
        rv_matching_list.setAdapter(matchingViewAdapter);

        RecyclerView rv_message_list = (RecyclerView) baseView.findViewById(R.id.rv_message_list);
        rv_message_list.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        messageListViewAdapter = new MessageListViewAdapter();
        rv_message_list.setAdapter(messageListViewAdapter);


        return baseView;

    }


    class MatchingViewAdapter extends RecyclerView.Adapter<MatchingViewHolder> {

        @Override
        public MatchingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View baseView = getActivity().getLayoutInflater().inflate(R.layout.item_matching, parent, false);
            MatchingViewHolder postViewHolder = new MatchingViewHolder(baseView);
            return postViewHolder;
        }

        @Override
        public void onBindViewHolder(MatchingViewHolder holder, int position) {


            holder.friendName.setText(matchingListDatas.get(position).getName());
            holder.friendPhoto.setImageResource(matchingListDatas.get(position).getPhoto());


        }

        @Override
        public int getItemCount() {
            return matchingListDatas.size();
        }
    }

    class MatchingViewHolder extends RecyclerView.ViewHolder {

        public TextView friendName;
        public CircularImageView friendPhoto;

        public MatchingViewHolder(View itemView) {
            super(itemView);
            friendName = (TextView) itemView.findViewById(R.id.friendName);
            friendPhoto = (CircularImageView) itemView.findViewById(R.id.friendPhoto);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ContentActivity.class);
                    startActivity(intent);

                }
            });

        }


    }

    class MessageListViewAdapter extends RecyclerView.Adapter<MessageListViewHolder> {

        @Override
        public MessageListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View baseView = getActivity().getLayoutInflater().inflate(R.layout.item_message_list, parent, false);
            MessageListViewHolder messageListViewHolder = new MessageListViewHolder(baseView);
            return messageListViewHolder;
        }

        @Override
        public void onBindViewHolder(MessageListViewHolder holder, int position) {


            holder.friendName.setText(messageListDatas.get(position).getName());
            holder.content.setText(messageListDatas.get(position).getContent());
            holder.friendPhoto.setImageResource(messageListDatas.get(position).getPhoto());


        }

        @Override
        public int getItemCount() {
            return matchingListDatas.size();
        }
    }

    class MessageListViewHolder extends RecyclerView.ViewHolder {

        public TextView friendName;
        public CircularImageView friendPhoto;
        public TextView content;

        public MessageListViewHolder(View itemView) {
            super(itemView);
            friendName = (TextView) itemView.findViewById(R.id.friendName);
            content = (TextView) itemView.findViewById(R.id.content);
            friendPhoto = (CircularImageView) itemView.findViewById(R.id.friendPhoto);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ChatActivity.class);
                    startActivity(intent);

                }
            });

        }


    }
}
