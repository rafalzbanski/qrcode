package pl.rafalzbanski.qrcode.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.rafalzbanski.qrcode.service.QRCodeService;

import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/api")
public class QRCodeController {

    private final QRCodeService qrCodeService;

    public QRCodeController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/qrcode")
    public ResponseEntity<BufferedImage> getQRCode(
            @RequestParam String contents,
            @RequestParam(defaultValue = "L") String correction,
            @RequestParam(defaultValue = "250") int size,
            @RequestParam(defaultValue = "png") String type) {

        BufferedImage qrCodeImage = qrCodeService.generateQRCodeImage(contents, size, correction);

        MediaType mediaType = switch (type.toLowerCase()) {
            case "png" -> MediaType.IMAGE_PNG;
            case "jpeg" -> MediaType.IMAGE_JPEG;
            case "gif" -> MediaType.IMAGE_GIF;
            default -> MediaType.IMAGE_PNG;
        };

        return ResponseEntity.ok().contentType(mediaType).body(qrCodeImage);
    }

    @GetMapping("/")
    public String showHomePage() {
        return "qrcode";
    }
}
