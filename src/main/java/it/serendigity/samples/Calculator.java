package it.serendigity.samples;

import java.awt.Image;
import java.net.URL;



/**
 * Sample JAVA calculator
 *
 * @author srusso
 */
public class Calculator {

	/**
	 * Sum <code>a</code> and <code>b</code> parameters and return the result
	 *
	 * @param a first
	 * @param b second
	 * @return result of a+b
	 */
	public int add( int a, int b ) {
		return a + b;
	}

	/**
	 * Multiply <code>a</code> and <code>b</code> parameters and return the result
	 *
	 * @param a first
	 * @param b second
	 * @return result of a*b
	 */
	public int mult( int a, int b ) {
		return a * b;
	}

	/**
	 * Check if number is odd.
	 *
	 * @param a number
	 * @return true if number is odd
	 */
	public boolean isOdd( int a ) {
		return a % 2 != 0;
	}

	/**
	 * JAVADOC with HTML Tag
	 *
	 * Returns an Image object that can then be painted on the screen.
	 * The url argument must specify an absolute <a href="java.net.URL">{@link java.net.URL}</a>. The name
	 * argument is a specifier that is relative to the url argument.
	 * <p>
	 * This method always returns immediately, whether or not the
	 * image exists. When this applet attempts to draw the image on
	 * the screen, the data will be loaded. The graphics primitives
	 * that draw the image will incrementally paint on the screen.
	 * <ul>
	 * <li> primo</li>
	 * <li> secondo</li>
	 *</ul>
	 *
	 * @param url an absolute URL giving the base location of the image
	 * @param name the location of the image, relative to the url argument
	 * @return the image at the specified URL
	 * @see Image
	 */
	public Image getMethodWithHTMLTag( URL url, String name ) {
		return null;
	}

}
