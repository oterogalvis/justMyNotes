package com.treehouse.docgen;

import com.treehouse.math.MathUtils;

/**
 * Created by jorgeotero on 5/18/17.
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Process the MathUtils class's annotations DONE
        DocProcessor.process(MathUtils.class);
    }
}
