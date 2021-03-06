package com.example.gitubusers.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gitubusers.OnCrossClickedAction;
import com.example.gitubusers.R;
import com.example.gitubusers.model.User;
import com.google.android.material.card.MaterialCardView;

public class ViewHolderFavory extends RecyclerView.ViewHolder {
    private ImageView vhFavAvatar_url;
    private TextView vhFavLogin;
    private TextView vhFavUrl;
    private ImageView vhDelete;

    public ViewHolderFavory(@NonNull View view) {
        super(view);
        vhFavAvatar_url=view.findViewById(R.id.raw_photo_favory);
        vhFavLogin=view.findViewById(R.id.raw_login_favory);
        vhFavUrl=view.findViewById(R.id.raw_url_favory);
        vhDelete=view.findViewById(R.id.rawBtnDelete);
    }

    public ImageView getVhFavAvatar_url() {
        return vhFavAvatar_url;
    }

    public void setVhFavAvatar_url(ImageView vhFavAvatar_url) {
        this.vhFavAvatar_url = vhFavAvatar_url;
    }

    public TextView getVhFavLogin() {
        return vhFavLogin;
    }

    public void setVhFavLogin(TextView vhFavLogin) {
        this.vhFavLogin = vhFavLogin;
    }

    public TextView getVhFavUrl() {
        return vhFavUrl;
    }

    public void setVhFavUrl(TextView vhFavUrl) {
        this.vhFavUrl = vhFavUrl;
    }

    public ImageView getVhDelete() {
        return vhDelete;
    }

    public void setVhDelete(ImageView vhDelete) {
        this.vhDelete = vhDelete;
    }

    public void bind(User user, OnCrossClickedAction onCrossClickedAction){
        vhFavLogin.setText(user.getLogin());
        vhFavUrl.setText(user.getUrl());
        Glide.with(vhFavAvatar_url.getContext())
                .load(user.getAvatar_url())
                .into(vhFavAvatar_url);
        vhDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCrossClickedAction.deleteUser(user);
            }
        });

    }
}
