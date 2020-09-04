package com.xyj.strokeaid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    @BindView(R.id.iv_arrow_view_nib)
    ImageView ivArrowViewNib;
    @BindView(R.id.rv_scores_view_nib)
    RecyclerView rvScoresViewNib;

    private List<ItemBean> mItemBeans;
    private NihssItemRvAdapter mItemRvAdapter;
    private NihssScoreRvAdapter mScoreRvAdapter;
    private OnScoreChangedListener mOnScoreChangedListener;

    public OnScoreChangedListener getOnScoreChangedListener() {
        return mOnScoreChangedListener;
    }

    public void setOnScoreChangedListener(OnScoreChangedListener onScoreChangedListener) {
        mOnScoreChangedListener = onScoreChangedListener;
    }

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

        boolean scoreVisible = typedArray.getBoolean(R.styleable.NihssItemBar_nib_score_visible, true);
        if (scoreVisible) {
            rvScoresViewNib.setVisibility(VISIBLE);
        } else {
            rvScoresViewNib.setVisibility(GONE);
        }

        float titleSize = typedArray.getDimension(R.styleable.NihssItemBar_nib_title_size, 12);
        tvTitleViewNib.setTextSize(TypedValue.COMPLEX_UNIT_SP, titleSize);

        typedArray.recycle();

        ivArrowViewNib.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rvContentViewNib.getVisibility() == VISIBLE) {
                    rvContentViewNib.setVisibility(GONE);
                    ivArrowViewNib.setImageResource(R.drawable.ic_arrow_down_blue);
                } else {
                    rvContentViewNib.setVisibility(VISIBLE);
                    ivArrowViewNib.setImageResource(R.drawable.ic_arrow_up_blue);
                    if (mItemRvAdapter != null) {
                        mItemRvAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    /**
     * 设置数据源
     *
     * @param itemBeans 数据源
     */
    public void setItemBeans(@NonNull List<ItemBean> itemBeans) {
        mItemBeans = itemBeans;
        if (mItemRvAdapter == null) {
            mItemRvAdapter = new NihssItemRvAdapter(mItemBeans);
        }
        rvContentViewNib.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContentViewNib.setAdapter(mItemRvAdapter);

        if (mScoreRvAdapter == null) {
            mScoreRvAdapter = new NihssScoreRvAdapter(mItemBeans);
        }
        rvScoresViewNib.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        if (rvScoresViewNib.getItemDecorationCount() == 0) {
            rvScoresViewNib.addItemDecoration(new SpacesItemDecoration(0, 0, 2, 0, HORIZONTAL));
        }
        rvScoresViewNib.setAdapter(mScoreRvAdapter);

        mItemRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (mItemBeans != null && mItemRvAdapter != null && mScoreRvAdapter != null) {
                    if (mItemBeans.get(position).checked) {
                        // 已经是选中状态，要取消选中
                        mItemBeans.get(position).checked = false;
                        if (mOnScoreChangedListener != null) {
                            mOnScoreChangedListener.subScore(mItemBeans.get(position).score);
                        }
                    } else {
                        // 修改为选中状态,清除其他项的选中状态
                        int oldScore = 0;
                        for (ItemBean itemBean : mItemBeans) {
                            if (itemBean.checked) {
                                oldScore = itemBean.score;
                            }
                        }
                        if (mOnScoreChangedListener != null) {
                            mOnScoreChangedListener.addScore(mItemBeans.get(position).score, oldScore);
                        }


                        for (int i = 0; i < mItemBeans.size(); i++) {
                            mItemBeans.get(i).checked = i == position;
                        }

                    }
                    mItemRvAdapter.notifyDataSetChanged();
                    mScoreRvAdapter.notifyDataSetChanged();
                }
            }
        });

        mScoreRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (mItemBeans != null && mItemRvAdapter != null && mScoreRvAdapter != null) {
                    if (mItemBeans.get(position).checked) {
                        // 已经是选中状态，要取消选中
                        mItemBeans.get(position).checked = false;
                    } else {
                        // 修改为选中状态,清除其他项的选中状态
                        for (int i = 0; i < mItemBeans.size(); i++) {
                            mItemBeans.get(i).checked = i == position;
                        }
                    }
                    mScoreRvAdapter.notifyDataSetChanged();
                    mItemRvAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    /**
     * 设置数据源,多选状态
     *
     * @param itemBeans 数据源
     */
    public void setMultipleItemBeans(@NonNull List<ItemBean> itemBeans) {
        mItemBeans = itemBeans;
        if (mItemRvAdapter == null) {
            mItemRvAdapter = new NihssItemRvAdapter(mItemBeans);
        }
        rvContentViewNib.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContentViewNib.setAdapter(mItemRvAdapter);

        if (mScoreRvAdapter == null) {
            mScoreRvAdapter = new NihssScoreRvAdapter(mItemBeans);
        }
        rvScoresViewNib.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        if (rvScoresViewNib.getItemDecorationCount() == 0) {
            rvScoresViewNib.addItemDecoration(new SpacesItemDecoration(0, 0, 2, 0, HORIZONTAL));
        }
        rvScoresViewNib.setAdapter(mScoreRvAdapter);

        mItemRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (mItemBeans != null && mItemRvAdapter != null && mScoreRvAdapter != null) {
                    mItemBeans.get(position).checked = !mItemBeans.get(position).checked;
                    mItemRvAdapter.notifyDataSetChanged();
                    mScoreRvAdapter.notifyDataSetChanged();
                }
            }
        });

        mScoreRvAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                if (mItemBeans != null && mItemRvAdapter != null && mScoreRvAdapter != null) {
                    mItemBeans.get(position).checked = !mItemBeans.get(position).checked;
                    mScoreRvAdapter.notifyDataSetChanged();
                    mItemRvAdapter.notifyDataSetChanged();
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

    public interface OnScoreChangedListener {
        /**
         * @param score
         */
        void addScore(int newScore, int oldScore);

        /**
         * @param score
         */
        void subScore(int score);
    }

    /**
     * 获取分数, 多选状态
     *
     * @return -1    没有选中项目
     * 其他   正常得分
     */
    public int getMultipleScore() {
        int count = -1;
        if (mItemBeans != null) {
            for (ItemBean itemBean : mItemBeans) {
                if (itemBean.checked) {
                    if (count == -1) {
                        // 在累加前把值置为0，防止有些选项的值就是0的情况导致计算错误
                        count = 0;
                    }
                    count += itemBean.score;
                }
            }
        }
        return count;
    }

    public static class NihssItemRvAdapter extends BaseQuickAdapter<ItemBean, BaseViewHolder> {

        public NihssItemRvAdapter(@Nullable List<ItemBean> data) {
            super(R.layout.adapter_rv_nihss_item, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, ItemBean itemBean) {
            CheckedTextView view = baseViewHolder.getView(R.id.ctv_content_view_nihss_item);
            view.setText(itemBean.content);
            view.setChecked(itemBean.checked);
        }
    }

    public static class NihssScoreRvAdapter extends BaseQuickAdapter<ItemBean, BaseViewHolder> {

        public NihssScoreRvAdapter(@Nullable List<ItemBean> data) {
            super(R.layout.adapter_rv_nihss_score, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, ItemBean itemBean) {
            CheckedTextView view = baseViewHolder.getView(R.id.tv_score_adapter_nihss);
            view.setText(String.valueOf(itemBean.score));
            view.setChecked(itemBean.checked);
        }
    }

    public static class ItemBean {
        public String content;
        public int score;
        public String scoreValue;
        public boolean checked;

        public ItemBean(String content, int score, String scoreValue, boolean checked) {
            this.content = content;
            this.score = score;
            this.scoreValue = scoreValue;
            this.checked = checked;
        }

        public ItemBean(String content, int score, boolean checked) {
            this.content = content;
            this.score = score;
            this.scoreValue = String.valueOf(score);
            this.checked = checked;
        }

        @Override
        public String toString() {
            return "ItemBean{" +
                    "content='" + content + '\'' +
                    ", score=" + score +
                    ", scoreValue='" + scoreValue + '\'' +
                    ", checked=" + checked +
                    '}';
        }
    }

    /**
     * RadioGroup选中RadioButton清除选中状态
     * @return
     *
     */
    public void clickRgClearState() {

        if (mItemBeans != null && mItemRvAdapter != null && mScoreRvAdapter != null) {

            if (mItemBeans != null) {
                for (ItemBean itemBean : mItemBeans) {
                    if (itemBean.checked) {
                        itemBean.checked = false;
                    }
                }
            }

            mScoreRvAdapter.notifyDataSetChanged();
            mItemRvAdapter.notifyDataSetChanged();
        }

    }

}

    
    
       
    