package sample;

import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.media.*;
import javafx.util.Duration;

public class PlayCard extends ImageView implements Cloneable {
    private Image shownImage;
    private final Image flipped = new Image("flipped.png"),
            unknown = new Image("http://clipart-library.com/images/8iAEy8jbT.png");
    private boolean isShown, isMatched = false, allowFlipping = true;
    static PlayCard selectedCard;
    static int imagesShown = 0;
    File matchFile = new File("Winning.mp3");
    Media matchSound = new Media(matchFile.toURI().toString());
           // buzzerSound = new Media("https://bigsoundbank.com/UPLOAD/mp3/0920.mp3");
    MediaPlayer matchPlayer = new MediaPlayer(matchSound);
   // MediaPlayer buzzerPlayer = new MediaPlayer(buzzerSound);
    Timeline showAnimation, flipAnimation, delay, AllowFlippingDelay;
    int flipHandlerVar = 99, showHandlerVar = 1;
    static int animationNumber = 0;

    public PlayCard() {
        setFitWidth(100);
        setFitHeight(100);
        setImage(unknown);
    }

    public PlayCard(Image image, Scores score) {
        setFitWidth(100);
        setFitHeight(100);
        System.out.println();
        setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)");
        EventHandler<ActionEvent> allowFlipHandler = e -> {
            setImagesShown(0);
            AllowFlippingDelay.stop();
            selectedCard.AllowFlippingDelay.stop();
        };
        EventHandler<ActionEvent> flipHandler = e -> {
            if (getFitWidth() <= 100 && getFitWidth() > 1 && animationNumber == 0) {
                setFitWidth(flipHandlerVar--);
                if (getFitWidth() == 1) {
                    flipHandlerVar = 99;
                    setImage(getShownImage());
                    showAnimation.play();
                }
            } else if (getFitWidth() <= 100 && getFitWidth() > 1 && animationNumber == 1) {
                setFitWidth(flipHandlerVar--);
                if (getFitWidth() == 1) {
                    flipHandlerVar = 99;
                    showAnimation.play();
                }

            } else if (getFitWidth() <= 100 && getFitWidth() > 1 && animationNumber == 2) {
                setFitWidth(flipHandlerVar--);
                if (getFitWidth() == 1) {
                    flipHandlerVar = 99;
                    showAnimation.play();
                }
            }

        };
        EventHandler<ActionEvent> showHandler = e -> {
            if (getFitWidth() < 100 && getFitWidth() >= 0 && animationNumber == 0) {
                setFitWidth(showHandlerVar++);
                if (getFitWidth() == 99 || getFitWidth() == 100) {
                    showHandlerVar = 1;
                }
            } else if (getFitWidth() < 100 && getFitWidth() >= 0 && animationNumber == 1) {

                setFitWidth(showHandlerVar++);
                setImage(getShownImage());
                if (getFitWidth() == 99 || getFitWidth() == 100) {
                    showHandlerVar = 1;
                }

            } else if (getFitWidth() < 100 && getFitWidth() >= 0 && animationNumber == 2) {
                setFitWidth(showHandlerVar++);
                setFlipped();
                if (getFitWidth() == 100) {
                    showHandlerVar = 1;
                }
            }

        };
        EventHandler<ActionEvent> delayHandler = e -> {

            animationNumber = 2;
            flipAnimation.play();
        };

        delay = new Timeline(new KeyFrame(Duration.millis(500), delayHandler));
        delay.setCycleCount(1);
        showAnimation = new Timeline(new KeyFrame(Duration.millis(2), showHandler));
        showAnimation.setCycleCount(99);
        flipAnimation = new Timeline(new KeyFrame(Duration.millis(2), flipHandler));
        flipAnimation.setCycleCount(99);
        AllowFlippingDelay = new Timeline(new KeyFrame(Duration.millis(1000), allowFlipHandler));
        AllowFlippingDelay.setCycleCount(2);
        setShownImage(image);
        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

                if (!isShown() && imagesShown == 0) {
                    animationNumber = 0;
                    flipAnimation.play();
                    setShown(true);
                    setSelectedCard((PlayCard) event.getSource());
                    selectedCard.setFlipAnimation(new Timeline(new KeyFrame(Duration.millis(2), flipHandler)));
                    selectedCard.getFlipAnimation().setCycleCount(99);
                    selectedCard.setShowAnimation(new Timeline(new KeyFrame(Duration.millis(2), showHandler)));
                    selectedCard.getShowAnimation().setCycleCount(99);
                    selectedCard.setDelay(new Timeline(new KeyFrame(Duration.millis(500), delayHandler)));
                    selectedCard
                            .setAllowFlippingDelay(new Timeline(new KeyFrame(Duration.millis(1000), allowFlipHandler)));
                    selectedCard.getDelay().setCycleCount(1);
                    selectedCard.getAllowFlippingDelay().setCycleCount(2);
                    selectedCard.setFlipHandlerVar(flipHandlerVar);
                    selectedCard.setShowHandlerVar(showHandlerVar);
                    imagesShown++;
                } else if (!isShown() && isMatchedURL() && !isMatched() && imagesShown == 1) {
                    AllowFlippingDelay.play();
                    selectedCard.AllowFlippingDelay.play();
                    imagesShown++;
                    animationNumber = 1;
                   // matchPlayer.play();
                    flipAnimation.play();
                    System.out.println("Matched!");
                    setShown(true);
                    setMatched(true);
                    score.calculateScore();
                    score.setRoundMoves(score.getRoundMoves() + 1);
                    score.setMatchedCounter(score.getMatchedCounter() + 1);
                    selectedCard.setMatched(true);
                } else if (!isMatchedURL() && !isMatched() && !isShown() && imagesShown == 1) {
                    AllowFlippingDelay.play();
                    selectedCard.AllowFlippingDelay.play();
                    System.out.println("Unmatched!");
                    imagesShown++;
                    animationNumber = 1;
                    flipAnimation.play();
                    delay.play();
                    selectedCard.delay.play();
                    score.setRoundMoves(score.getRoundMoves() + 1);
                    setShown(false);
                    selectedCard.setShown(false);
                }
            }
        });
    }

    public File getMatchFile() {
        return matchFile;
    }

    public void setMatchFile(File matchFile) {
        this.matchFile = matchFile;
    }

    public Media getMatchSound() {
        return matchSound;
    }

    public void setMatchSound(Media matchSound) {
        this.matchSound = matchSound;
    }



    public MediaPlayer getMatchPlayer() {
        return matchPlayer;
    }

    public void setMatchPlayer(MediaPlayer matchPlayer) {
        this.matchPlayer = matchPlayer;
    }



    public Timeline getAllowFlippingDelay() {
        return AllowFlippingDelay;
    }

    public void setAllowFlippingDelay(Timeline allowFlippingDelay) {
        AllowFlippingDelay = allowFlippingDelay;
    }

    public int getFlipHandlerVar() {
        return flipHandlerVar;
    }

    public void setFlipHandlerVar(int flipHandlerVar) {
        this.flipHandlerVar = flipHandlerVar;
    }

    public static int getAnimationNumber() {
        return animationNumber;
    }

    public static void setAnimationNumber(int animationNumber) {
        PlayCard.animationNumber = animationNumber;
    }

    public int getShowHandlerVar() {
        return showHandlerVar;
    }

    public void setShowHandlerVar(int showHandlerVar) {
        this.showHandlerVar = showHandlerVar;
    }

    public Timeline getDelay() {
        return delay;
    }

    public void setDelay(Timeline delay) {
        this.delay = delay;
    }

    public Timeline getShowAnimation() {
        return showAnimation;
    }

    public void setShowAnimation(Timeline showAnimation) {
        this.showAnimation = showAnimation;
    }

    public Timeline getFlipAnimation() {
        return flipAnimation;
    }

    public void setFlipAnimation(Timeline flipAnimation) {
        this.flipAnimation = flipAnimation;
    }

    // to get the shown image of the card
    public Image getShownImage() {
        return shownImage;
    }

    // to set the shown image of the card
    public void setShownImage(Image shownImage) {
        this.shownImage = shownImage;
    }

    // to flip the card.
    public void setFlipped() {
        setImage(flipped);
    }

    // to find if the card is shown.
    public boolean isShown() {
        return isShown;
    }

    public boolean isMatched() {
        return isMatched;
    }

    // to change the status of isMatched
    public void setMatched(boolean matched) {
        this.isMatched = matched;
    }

    // to get the flipped image.
    public Image getFlipped() {
        return flipped;
    }

    // to get the unknown image.
    public Image getUnknown() {
        return unknown;
    }

    // to set isShown.
    public void setShown(boolean isShown) {
        this.isShown = isShown;
    }

    // to set the SelectedImageCard Object.
    public static void setSelectedCard(PlayCard selectedCard) {
        PlayCard.selectedCard = selectedCard;
    }

    // to find if the cards are matched.
    public boolean isMatchedURL() {
        if (getShownImage().getPixelReader().equals(selectedCard.getShownImage().getPixelReader())) {
            return true;
        }

        return false;
    }

    // to get the SelectedImageCard Object
    public static PlayCard getSelectedCard() {
        return selectedCard;
    }

    // to get the card content.
    public static int getImagesShown() {
        return imagesShown;
    }

    // to set the card content.
    public static void setImagesShown(int imagesShown) {
        PlayCard.imagesShown = imagesShown;
    }

    public boolean isAllowFlipping() {
        return allowFlipping;
    }

    public void setAllowFlipping(boolean allowFlipping) {
        this.allowFlipping = allowFlipping;
    }

}
