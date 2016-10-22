package net.adamhilton.handylyst.ui.edit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import net.adamhilton.handylyst.R;
import net.adamhilton.handylyst.data.model.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditActivity extends AppCompatActivity implements EditScreenContract.View {

    private EditPresenter presenter;

    @BindView(R.id.edit_name_text)
    EditText name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);

        presenter = new EditPresenter(this);
    }

    @OnClick(R.id.cancel)
    public void onCancelClicked() {
        super.onBackPressed();
    }

    @OnClick(R.id.save)
    public void onSaveClicked() {
        List list = new List();
        list.Name = String.valueOf(name.getText());
        presenter.CreateList(list);
    }

    @Override
    public void GoBack() {
        super.onBackPressed();
    }
}
