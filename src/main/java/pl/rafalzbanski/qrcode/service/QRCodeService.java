package pl.rafalzbanski.qrcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Map;

@Service
public class QRCodeService {

    public BufferedImage generateQRCodeImage(String contents, int size, String correction) {
        QRCodeWriter writer = new QRCodeWriter();
        Map<EncodeHintType, ErrorCorrectionLevel> hints = Map.of(
                EncodeHintType.ERROR_CORRECTION, switch (correction) {
                    case "M" -> ErrorCorrectionLevel.M;
                    case "Q" -> ErrorCorrectionLevel.Q;
                    case "H" -> ErrorCorrectionLevel.H;
                    default -> ErrorCorrectionLevel.L;
                }
        );

        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, size, size, hints);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            throw new RuntimeException("Error generating QR code", e);
        }
    }
}
