package com.example.demo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api")
public class Hello {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello from service";
    }

@GetMapping("/image")
        public  byte[] exampleForSO(BufferedImage image) {
            BufferedImage imageIn = image;
            BufferedImage imageOut =
                    new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
            int width = imageIn.getWidth();
            int height = imageIn.getHeight();
            int[] imageInPixels = imageIn.getRGB(0, 0, width, height, null, 0, width);
            int[] imageOutPixels = new int[imageInPixels.length];
            for (int i = 0; i < imageInPixels.length; i++) {
                int alpha = (imageInPixels[i] & 0xFF000000) >> 24;
                int red = (imageInPixels[i] & 0x00FF0000) >> 16;
                int green = (imageInPixels[i] & 0x0000FF00) >> 8;
                int blue = (imageInPixels[i] & 0x000000FF) >> 0;

                // Make any change to the colors.
//                if (  conditionCheckerForRedGreenAndBlue  ){
//                    // bla bla bla
//                } else {
//                    // yada yada yada
//                }

                // At last, store in output array:
                imageOutPixels[i] = (alpha & 0xFF) << 24
                        | (red & 0xFF) << 16
                        | (green & 0xFF) << 8
                        | (blue & 0xFF);

            }
            imageOut.setRGB(0, 0, width, height, imageOutPixels, 0, width);
            return imageOut.toString().getBytes();
        }

}
