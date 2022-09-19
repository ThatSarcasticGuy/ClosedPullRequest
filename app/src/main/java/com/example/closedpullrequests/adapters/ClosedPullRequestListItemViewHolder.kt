package com.example.closedpullrequests.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.closedpullrequests.R
import com.example.closedpullrequests.databinding.LayoutClosedPullRequestListItemBinding
import com.example.closedpullrequests.model.ClosedPullRequest
import com.example.closedpullrequests.utils.getFormattedDate
import com.example.closedpullrequests.utils.toDp

class ClosedPullRequestListItemViewHolder(
    private val binding: LayoutClosedPullRequestListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(request: ClosedPullRequest) {
        with(binding) {
            title.text = request.title
            openedAtValue.text = getFormattedDate(request.createdAt)
            closedAtValue.text = getFormattedDate(request.closedAt)
            ownerValue.text = request.user.userName
            Glide.with(root)
                .load(request.user.userImageUrl)
                .placeholder(R.drawable.img_loading_bg)
                .circleCrop()
                .override(root.context.toDp(60), root.context.toDp(60))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ownerIv)
        }
    }

    companion object {
        fun from(parent: ViewGroup): ClosedPullRequestListItemViewHolder =
            ClosedPullRequestListItemViewHolder(
                LayoutClosedPullRequestListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
    }
}
