package dylar.bitb.testproject.ui.model;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dylar.bitb.testproject.R;
import dylar.bitb.testproject.utils.Logger;


public class GooAndPrickleAdapter extends RecyclerView.Adapter<ViewHolder> {

    public static final int VIEW_GOO = 1;
    public static final int VIEW_PRICKLE = 2;

    private IGooAndPrickleView gooAndPrickleView;

    public GooAndPrickleAdapter(IGooAndPrickleView gooAndPrickleView) {
        this.gooAndPrickleView = gooAndPrickleView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_GOO:
                Logger.error("create GOO");
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_dashboard_row_goo, parent, false);
                return new GooViewHolder(view);
            case VIEW_PRICKLE:
                Logger.error("create PRICKLE");
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_dashboard_row_prickle, parent, false);
                return new PrickleViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case VIEW_GOO:
                Logger.error("bind GOO");
                gooAndPrickleView.setRowGoo((IGooRowView) holder, position);
                break;
            case VIEW_PRICKLE:
                Logger.error("bind PRICKLE");
                gooAndPrickleView.setRowPrickle((IPrickleRowView) holder, position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return VIEW_GOO;
        } else
            return VIEW_PRICKLE;
    }

    @Override
    public int getItemCount() {
        return gooAndPrickleView.getListCount();
    }
}
