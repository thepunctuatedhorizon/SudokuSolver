package com.thepunctuatedhorizon.sudokusolver;
import android.util.Log;
import android.widget.TextView;

import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;

public class Reader {

    public void Read(TextView textView) throws Exception {
        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(".", "ENG") != 0) {
            Log.e("Travail","Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        PIX image = pixRead("test.png");
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        String string = outText.getString();
        if (!string.isEmpty()) {

            textView.setText("OCR output:\n" + string);
        }
        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);
    }
}