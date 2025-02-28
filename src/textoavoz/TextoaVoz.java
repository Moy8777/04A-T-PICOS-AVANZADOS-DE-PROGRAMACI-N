package textoavoz;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextoaVoz {
    
    public static void convertir(String texto) {
        System.setProperty("freetts.voices",
            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        Voice voice = VoiceManager.getInstance().getVoice("kevin16");

        if (voice != null) {
            voice.allocate();
            voice.speak(texto);
            voice.deallocate();
        } else {
            System.out.println("Error al obtener la voz");
        }
    }
}
