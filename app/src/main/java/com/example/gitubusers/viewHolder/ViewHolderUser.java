package com.example.gitubusers.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.gitubusers.OnImageClickedAction;
import com.example.gitubusers.R;
import com.example.gitubusers.model.User;
import com.google.android.material.card.MaterialCardView;

public class ViewHolderUser extends RecyclerView.ViewHolder {
    private ImageView vhAvatar_url;
    private TextView vhLogin;
    private TextView vhUrl;
    private MaterialCardView materialCardView;

    public ViewHolderUser(@NonNull View view) {
        super(view);
        vhAvatar_url =view.findViewById(R.id.rawPhotoUser);
        vhLogin=view.findViewById(R.id.rawLoginUser);
        vhUrl=view.findViewById(R.id.rawUrlUser);
        materialCardView=view.findViewById(R.id.raw_material_card_user);
    }

    public ImageView getVhAvatar_url() {
        return vhAvatar_url;
    }

    public void setVhAvatar_url(ImageView vhAvatar_url) {
        this.vhAvatar_url = vhAvatar_url;
    }

    public TextView getVhLogin() {
        return vhLogin;
    }

    public void setVhLogin(TextView vhLogin) {
        this.vhLogin = vhLogin;
    }

    public TextView getVhUrl() {
        return vhUrl;
    }

    public void setVhUrl(TextView vhUrl) {
        this.vhUrl = vhUrl;
    }

    public MaterialCardView getMaterialCardView() {
        return materialCardView;
    }

    public void setMaterialCardView(MaterialCardView materialCardView) {
        this.materialCardView = materialCardView;
    }

    public void bind(User user, OnImageClickedAction onImageClickedAction){
        vhLogin.setText(user.getLogin());
        vhUrl.setText(user.getUrl());
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageClickedAction.intentDescription(user);
            }
        });

          Glide.with(vhAvatar_url.getContext())
                .load(user.getAvatar_url())
                .into(vhAvatar_url);

    }
}
