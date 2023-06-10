package a2_BI12_006.studentman;

/**
 * @overview
 * An interface represent all kinds of document
 */
interface Document {
    /**
     * @effects
     * return a HTML string that represents the document in the format:
     * <pre>
     * &lt;html&gt;
     * &lt;head&gt;&lt;title&gt;  title_here  &lt;/title&gt;
     * &lt;body&gt;
     *      body_here
     * &lt;/body&gt;&lt;/html&gt;
     * </pre>
     */
    public String toHtmlDoc();
}
