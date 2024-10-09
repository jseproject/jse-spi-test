package org.jseproject.test;

import javasound.enhancement.sampled.Audios;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class TestDecode {

    private static final String AUDIO_FILE_NAME = "16kHz_stereo";
    private void testDecode(String extension) throws UnsupportedAudioFileException, IOException {
        try (AudioInputStream encodedInputStream = Audios.getAudioInputStream(Thread.currentThread().getContextClassLoader(), AUDIO_FILE_NAME + "." + extension)) {
            AudioFormat encodedFormat = encodedInputStream.getFormat();
            AudioSystem.getAudioInputStream(
                    new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, encodedFormat.getSampleRate(), 16,
                            encodedFormat.getChannels(), 2 * encodedFormat.getChannels(), encodedFormat.getFrameRate(),
                            encodedFormat.isBigEndian(), encodedFormat.properties()),
                    encodedInputStream);
        }

        Audios.getAudioFileFormat(Thread.currentThread().getContextClassLoader(), AUDIO_FILE_NAME + "." + extension);
    }

    @Test
    public void testDecodeWAV() throws UnsupportedAudioFileException, IOException {
        testDecode("wav");
    }

    @Test
    public void testDecodeAIFF() throws UnsupportedAudioFileException, IOException {
        testDecode("aiff");
    }

    @Test
    public void testDecodeAU() throws UnsupportedAudioFileException, IOException {
        testDecode("au");
    }

    @Test
    public void testDecodeFLAC() throws UnsupportedAudioFileException, IOException {
        testDecode("flac");
    }

    @Test
    public void testDecodeOpus() throws UnsupportedAudioFileException, IOException {
        testDecode("opus");
    }

    @Test
    public void testDecodeSpeex() throws UnsupportedAudioFileException, IOException {
        testDecode("spx");
    }

    @Test
    public void testDecodeVorbis() throws UnsupportedAudioFileException, IOException {
        testDecode("ogg");
    }

    @Test
    public void testDecodeMP3() throws UnsupportedAudioFileException, IOException {
        testDecode("mp3");
    }

    @Test
    public void testDecodeAAC() throws UnsupportedAudioFileException, IOException {
        testDecode("aac");
    }

}
