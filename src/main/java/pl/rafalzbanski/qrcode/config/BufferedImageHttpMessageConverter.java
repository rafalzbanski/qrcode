package pl.rafalzbanski.qrcode.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class BufferedImageHttpMessageConverter implements HttpMessageConverter<BufferedImage> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return BufferedImage.class.isAssignableFrom(clazz);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(MediaType.IMAGE_PNG);
    }

    @Override
    public BufferedImage read(Class<? extends BufferedImage> clazz, HttpInputMessage inputMessage) {
        return null;
    }

    @Override
    public void write(BufferedImage bufferedImage, MediaType contentType, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        HttpHeaders headers = outputMessage.getHeaders();
        headers.setContentType(contentType);
        ImageIO.write(bufferedImage, contentType.getSubtype().toUpperCase(), outputMessage.getBody());
    }
}
