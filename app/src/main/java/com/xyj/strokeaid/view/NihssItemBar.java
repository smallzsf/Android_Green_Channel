package com.xyj.strokeaid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.helper.SpacesItemDecoration;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * NihssItemBar
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/22
 * email ：licy3051@qq.com
 */
public class NihssItemBar extends LinearLayout {

    @BindView(R.id.tv_title_view_nib)
    TextView tvTitleViewNib;
    @BindView(R.id.rv_content_view_nib)
    RecyclerView rvContentViewNib;

    private List<ItemBean> mItemBeans;
    private NihssRvAdapter mNihssRvAdapter;

    public NihssItemBar(Context context) {
        this(context, null);
    }

    public NihssItemBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NihssItemBar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public NihssItemBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_nhiss_item_bar, this);
        ButterKnife.bind(this, view);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NihssItemBar);

        String title = typedArray.getString(R.styleable.NihssItemBar_title);
        if (!TextUtils.isEmpty(title)) {
            tvTitleViewNib.setText(title);
        }
        typedArray.recycle();

    }

    public void setItemBeans(@NonNull List<ItemBean> itemBeans) {
        mItemBeans = itemBeans;
        if (mNihssRvAdapter == null) {
            mNihssRvAdapter = new NihssRvAdapter(mItemBeans);
        }
        rvContentViewNib.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContentViewNib.setAdapter(mNihssRvAdapter);

        mNihssRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (mItemBeans != null && mNihssRvAdapter != null) {
                    if (mItemBeans.get(position).checked) {
                        // 已经是选中状态，要取消选中
                        mItemBeans.get(position).checked = false;
                    } else {
                        // 修改为选中状态,清除其他项的选中状态
                        for (int i = 0; i < mItemBeans.size(); i++) {
                            mItemBeans.get(i).checked = i == position;
                        }
                    }
                    mNihssRvAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    /**
     * 获取分数
     *
     * @return -1    没有选中项目
     * 其他   正常得分
     */
    public int getScore() {
        if (mItemBeans != null) {
            for (ItemBean itemBean : mItemBeans) {
                if (itemBean.checked) {
                    return itemBean.score;
                }
            }
        }
        return -1;
    }


    public static class NihssRvAdapter extends BaseQuickAdapter<ItemBean, BaseViewHolder> {

        public NihssRvAdapter(@Nullable List<ItemBean> data) {
            super(R.layout.adapter_rv_nihss_item, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, ItemBean itemBean) {
            TextView view = baseViewHolder.getView(R.id.rb_content_view_nihss_item);
            view.setText(itemBean.content);
            if (itemBean.checked) {
                // 选中状态
                view.setBackground(new ColorDrawable(view.getContext().getResources().getColor(R.color.colorPrimary)));
                view.setTextColor(Color.WHITE);
            } else {
                // 非选中状态
                view.setBackground(new ColorDrawable(Color.WHITE));
                view.setTextColor(Color.BLACK);
            }
        }
    }

    public static class ItemBean {
        public String content;
        public int score;
        public boolean checked;

        @Override
        public String toString() {
            return "ItemBean{" +
                    "content='" + content + '\'' +
                    ", score=" + score +
                    ", checked=" + checked +
                    '}';
        }

        public ItemBean(String content, int score, boolean checked) {
            this.content = content;
            this.score = score;
            this.checked = checked;
        }

    }
}

    
    
       
    