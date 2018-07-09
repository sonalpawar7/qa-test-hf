package com.hf.utils;

public class SafeBrowserActions extends BrowserInitializer {


    /**
     * Load a new web page in the current browser window.
     *
     * @param url The URL to load. It is best to use a fully qualified URL
     */
    public void openUrl(String url) {
        getDriver().navigate().to(url);
    }

    /**
     * Move back a single "item" in the browser's history.
     */
    public void navigateBack() {
        getDriver().navigate().back();
    }

    /**
     * Move a single "item" forward in the browser's history.
     * Does nothing if we are on the latest page viewed.
     */
    public void navigateForward() {
        getDriver().navigate().forward();
    }

    /**
     * Refresh the current page
     */
    public void refresh() {
        getDriver().navigate().refresh();
    }
}
