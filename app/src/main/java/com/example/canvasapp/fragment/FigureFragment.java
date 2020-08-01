package com.example.canvasapp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.canvasapp.R;
import com.example.canvasapp.customView.CustomColor;
import com.example.canvasapp.customView.FigureEnum;
import com.example.canvasapp.customView.figure.Circle;
import com.example.canvasapp.customView.Point;
import com.example.canvasapp.customView.figure.Ellipse;
import com.example.canvasapp.customView.figure.Rectangle;
import com.example.canvasapp.customView.figure.Square;
import com.example.canvasapp.databinding.FragmentFigureBinding;

public class FigureFragment extends Fragment {

    private FragmentFigureBinding binding;

    private Button[] buttons;
    private View prevSelect;
    private FigureEnum actionButton;

    public static FigureFragment newInstance() {

        Bundle args = new Bundle();

        FigureFragment fragment = new FigureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_figure, container, false);

        binding.circle.setFigure(new Circle(new Point(300, 300, new CustomColor(22, 12,23)), 70));

        binding.btnCreate.setOnClickListener(v -> {

            if(actionButton != null){
                switch (actionButton){
                    case Circle:
                        int radiusCircle = getNormalProperties(binding.etRadius);
                        if(radiusCircle != 0){
                            int red = binding.sbRed.getProgress();
                            int green = binding.sbGreen.getProgress();
                            int blue = binding.sbBlue.getProgress();

                            binding.circle.setFigure(new Circle(new Point(100, 200, new CustomColor(red*25, green*25, blue*25)), radiusCircle));

                        } else {
                            Toast.makeText(getContext(), "Введите значение радиуса", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case Ellipse:
                        int radiusEllipseFirst = getNormalProperties(binding.etRadius);
                        int radiusEllipseSecond = getNormalProperties(binding.etRadius2);
                        if(radiusEllipseFirst != 0 && radiusEllipseSecond != 0){
                            int red = binding.sbRed.getProgress();
                            int green = binding.sbGreen.getProgress();
                            int blue = binding.sbBlue.getProgress();

                            binding.circle.setFigure(new Ellipse(new Point(100, 200, new CustomColor(red*25, green*25, blue*25)), radiusEllipseFirst, radiusEllipseSecond));
                        } else {
                            Toast.makeText(getContext(), "Введите значение радиуса", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case Rectangle:
                        int widthRectangle = getNormalProperties(binding.etWidth);
                        int heightRectangle = getNormalProperties(binding.etHeight);
                        if(widthRectangle != 0 && heightRectangle != 0){
                            int red = binding.sbRed.getProgress();
                            int green = binding.sbGreen.getProgress();
                            int blue = binding.sbBlue.getProgress();

                            binding.circle.setFigure(new Rectangle(new Point(100, 200, new CustomColor(red*25, green*25, blue*25)), widthRectangle, heightRectangle));
                        } else {
                            Toast.makeText(getContext(), "Введите значение высоты или ширины", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case Square:
                        int widthSquare = getNormalProperties(binding.etWidth);
                        if(widthSquare != 0 ){
                            int red = binding.sbRed.getProgress();
                            int green = binding.sbGreen.getProgress();
                            int blue = binding.sbBlue.getProgress();

                            binding.circle.setFigure(new Square(new Point(100, 200, new CustomColor(red*25, green*25, blue*25)), widthSquare));
                        } else {
                            Toast.makeText(getContext(), "Введите значение стороны", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        });

        final Handler handler = new Handler();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.circle.invalidate();
                handler.postDelayed(this, 2000);
            }
        }, 2000);

        settingsChooseFigure();

        return binding.getRoot();
    }

    private void settingsChooseFigure(){
        buttons = new Button[]{
                binding.menu.circle,
                binding.menu.rect,
                binding.menu.square,
                binding.menu.ellipse
        };

        for(Button b : buttons){
            b.setOnClickListener(this::actionButton);
        }
    }

    private void actionButton(View v){
        v.setBackgroundResource(R.drawable.select_button);

        if(v == binding.menu.circle){
            actionButton = FigureEnum.Circle;
        } else {
            if(v == binding.menu.ellipse){
                actionButton = FigureEnum.Ellipse;
            } else {
                if(v == binding.menu.rect){
                    actionButton = FigureEnum.Rectangle;
                } else {
                    if(v == binding.menu.square){
                        actionButton = FigureEnum.Square;
                    }
                }
            }
        }

        if(prevSelect != null){
            prevSelect.setBackgroundResource(R.drawable.unselect_button);
        }
        prevSelect = v;
    }

    private int getNormalProperties(EditText editText){
        return (!editText.getText().toString().equals("") ) ?
                    Integer.parseInt(editText.getText().toString()) :
                    0;
    }
}
