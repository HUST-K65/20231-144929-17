package main.pmchamcong;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private AnchorPane opacityPane,drawerPane;
    @FXML private Label drawerImage;
    @FXML private ImageView exit, image12, image09, image11, image10, detail11,detail10, detail12,detail09;
    @FXML private AnchorPane bangCongCaNhan, lichSuPage, xinNghi, dangKyThemGio, congTac, diMuonVeSom, chamCongBu;
    @FXML private DatePicker datePicker;

    public void onClickBangCongCaNhan(){
        bangCongCaNhan.toFront();
        this.onMouseClickOpacityPanel();
    }
    public void onClickLichsuPage(){
        lichSuPage.toFront();
        this.onMouseClickOpacityPanel();
    }
    public void onClickXinNghi(){
        xinNghi.toFront();
        this.onMouseClickOpacityPanel();
    }

    public void onClickDangKyThemGio(){
        dangKyThemGio.toFront();
        this.onMouseClickOpacityPanel();
    }

    public void onClickCongTac(){
        congTac.toFront();
        this.onMouseClickOpacityPanel();
    }

    public void onClickDiMuonVeSom(){
        diMuonVeSom.toFront();
        this.onMouseClickOpacityPanel();
    }

    public void onClickChamCongBu(){
        chamCongBu.toFront();
        this.onMouseClickOpacityPanel();
    }

    public void onMouseClickDrawImage(){
        this.setAnimationOnClick(true);
    }

    public void onMouseClickOpacityPanel(){
        this.setAnimationOnClick(false);
    }

    public void onChangeDatePicker(){
        LocalDate value = datePicker.getValue();
        int month = value.getMonth().getValue();
        this.setImageDetail(month);
    }

    private void setImageDetail(int month){
        switch (month) {
            case 12 -> {
                detail12.toFront();
                image12.toFront();
            }
            case 9 -> {
                detail09.toFront();
                image09.toFront();
            }
            case 11 -> {
                image11.toFront();
                detail11.toFront();
            }
            case 10 -> {
                image10.toFront();
                detail10.toFront();
            }
            default -> image12.toFront();
        }
    }

    private void setAnimationOnClick(boolean isShowMenu){
        FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5),opacityPane);
        TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5),drawerPane);

        if(isShowMenu){
            opacityPane.setVisible(true);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.5);
            fadeTransition1.play();
            translateTransition1.setByX(+600);
            translateTransition1.play();
        }else{
            fadeTransition1.setFromValue(0.5);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();
            fadeTransition1.setOnFinished(event -> opacityPane.setVisible(false));
            translateTransition1.setByX(-600);
            translateTransition1.play();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("vao console log");
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        datePicker.setValue(LocalDate.now());
        datePicker.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate localDate) {
                DateTimeFormatter dft = DateTimeFormatter.ofPattern("MM-yyyy");
                return dft.format(localDate);
            }

            @Override
            public LocalDate fromString(String s) {
                return null;
            }
        });
        this.onChangeDatePicker();

        opacityPane.setVisible(false);

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),opacityPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),drawerPane);
        translateTransition.setByX(-600);
        translateTransition.play();

    }
}
