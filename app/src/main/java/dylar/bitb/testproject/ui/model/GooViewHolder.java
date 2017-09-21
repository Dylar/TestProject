package dylar.bitb.testproject.ui.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dylar.bitb.testproject.R;
import dylar.bitb.testproject.model.Goo;
import lombok.Getter;


class GooViewHolder extends RecyclerView.ViewHolder implements IGooRowView {

    @BindView(R.id.adapter_dashboard_row_text1)
    protected TextView textView;

    private View view;

    @Getter
    private Goo goo;

    public GooViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        view = itemView;
    }

    @Override
    public void setGoo(Goo goo) {
        this.goo = goo;
        textView.setText(goo.getUuid());
    }

    @Override
    public void setDetailClickListener(IGooAndPrickleView gooAndPrickleView) {
        view.setOnClickListener(v -> gooAndPrickleView.openGooDetails(goo.getUuid()));
    }
}
