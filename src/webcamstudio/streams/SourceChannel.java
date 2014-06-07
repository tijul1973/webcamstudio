/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.streams;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import webcamstudio.channels.transitions.Transition;
import webcamstudio.sources.effects.Effect;

/**
 *
 * @author patrick (modified by karl)
 */
public class SourceChannel  {

    public static SourceChannel getChannel(String channelName, Stream stream) {
        SourceChannel s = new SourceChannel();
        s.x = stream.x;
        s.y = stream.y;
        s.width = stream.width;
        s.height = stream.height;
        s.opacity = stream.opacity;
        s.effects.addAll(stream.effects);
        s.startTransitions.addAll(stream.startTransitions);
        s.endTransitions.addAll(stream.endTransitions);
        s.volume = stream.volume;
        s.zorder = stream.zorder;
        s.name = channelName;
        s.isPlaying = stream.isPlaying();
        s.capHeight = stream.captureHeight;
        s.capWidth = stream.captureWidth;
        if (stream instanceof SourceText) {
            SourceText st = (SourceText) stream;
            s.isATimer = st.getIsATimer();
            s.isQRCode = st.getIsQRCode();
            if (st.getIsATimer()) {
                if (st.getIsQRCode()) {
                    s.text = "QRCode Clock Mode.";
                    st.updateContent("QRCode Clock Mode.");
                } else {
                    s.text = "Text Clock Mode.";
                    st.updateContent("Text Clock Mode.");
                }
            } else {
                s.text = st.content;
            }
            s.font = st.fontName;
            s.color = st.color;
        }
        return s;
    }

    private int x = 0;
    private int y = 0;
    private int capWidth = 0;
    private int capHeight = 0;
    private int width = 0;
    private int height = 0;
    private int opacity = 0;
    private float volume = 0;
    private int zorder = 0;
    private String text = "";
    private String font = "";
    private int color = 0;
    private String name = "";
    private boolean isATimer = false;
    private boolean isQRCode = false;
    private boolean isPlaying = false;
    ArrayList<Effect> effects = new ArrayList<>();
    private final boolean followMouse = false;
    private final int captureX = 0;
    private final int captureY = 0;
    public ArrayList<Transition> startTransitions = new ArrayList<>();
    public ArrayList<Transition> endTransitions = new ArrayList<>();

    public SourceChannel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }
    public void setText(String nt) {
        text = nt;
    }
    public void setFont(String nf) {
        font = nf;
    }
    public synchronized void addEffects(Effect fX) {
        effects.add(fX);
    }
    public void apply(final Stream s) {
        final SourceChannel instance = this;
        new Thread(new Runnable() {

            @Override
            public void run() {
                if (!s.getClass().toString().contains("Sink")){ // Don't Update SinkStreams
                    ExecutorService pool = java.util.concurrent.Executors.newCachedThreadPool();
                    if (endTransitions != null) {
                        for (Transition t : s.endTransitions) {
                            pool.submit(t.run(instance));
                        }
                        pool.shutdown();
                        try {
                            pool.awaitTermination(10, TimeUnit.SECONDS);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SourceChannel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    if (isPlaying) {
                        if (!s.isPlaying()) {
                            s.read();
                        }
                        if (startTransitions != null) {
                            pool = java.util.concurrent.Executors.newCachedThreadPool();
                            for (Transition t : instance.startTransitions) {
                                pool.submit(t.run(instance));
                            }
                            pool.shutdown();
                            try {
                                pool.awaitTermination(10, TimeUnit.SECONDS);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(SourceChannel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {
                        if (s.isPlaying()) {
                            s.stop();
                        }
                    }

                    s.x = getX();
                    s.y = getY();
                    s.width = getWidth();
                    s.height = getHeight();
                    s.opacity = getOpacity();
                    s.volume = getVolume();
                    s.zorder = getZorder();
                    s.captureHeight = getCapHeight();
                    s.captureWidth = getCapWidth();
                    s.effects.clear();
                    s.startTransitions.clear();
                    s.endTransitions.clear();
                    if (effects != null) {                        
                        s.effects.addAll(effects);
                    }
                    if (startTransitions != null){
                        s.startTransitions.addAll(startTransitions);
                    }
                    if (endTransitions != null) {   
                        s.endTransitions.addAll(endTransitions);
                    }       
                    if (s instanceof SourceText) {
                        SourceText st = (SourceText) s;
                        st.isATimer = getIsATimer();
                        st.isQRCode = getIsQRCode();
                        st.content = getText();
                        st.fontName = getFont();
                        st.color = getColor();
                        st.updateContent(getText());
                    }               
                    s.updateStatus();
                }
            }
        }).start();

    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    public void setX(int xp) {
        x = xp;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    public void setY(int yp) {
        y = yp;
    }

    /**
     * @return the capWidth
     */
    public int getCapWidth() {
        return capWidth;
    }

    public void setCapWidth(int cWidth) {
        capWidth = cWidth;
    }
    /**
     * @return the capHeight
     */
    public int getCapHeight() {
        return capHeight;
    }

    public void setCapHeight(int cHeight) {
        capHeight = cHeight;
    }
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    public void setWidth(int cWidth) {
        width = cWidth;
    }
    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    public void setHeight(int cHeight) {
        height = cHeight;
    }
    /**
     * @return the opacity
     */
    public int getOpacity() {
        return opacity;
    }

    /**
     * @return the volume
     */
    public float getVolume() {
        return volume;
    }

    /**
     * @return the zorder
     */
    public int getZorder() {
        return zorder;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @return the font
     */
    public String getFont() {
        return font;
    }

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }
    
    public boolean getIsATimer() {
        return isATimer;
    }
    
    public boolean getIsQRCode() {
        return isQRCode;
    }
    
    /**
     * @return the followMouse
     */
    public boolean isFollowMouse() {
        return followMouse;
    }

    /**
     * @return the captureX
     */
    public int getCaptureX() {
        return captureX;
    }

    /**
     * @return the captureY
     */
    public int getCaptureY() {
        return captureY;
    }

}