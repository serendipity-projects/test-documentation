/*
 * Copyright (c) 1995, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package it.serendigity.samples.nested;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * Class {@code URL} represents a Uniform Resource
 * Locator, a pointer to a "resource" on the World
 * Wide Web. A resource can be something as simple as a file or a
 * directory, or it can be a reference to a more complicated object,
 * such as a query to a database or to a search engine. More
 * information on the types of URLs and their formats can be found at:
 * <a href=
 * "http://web.archive.org/web/20051219043731/http://archive.ncsa.uiuc.edu/SDG/Software/Mosaic/Demo/url-primer.html">
 * <i>Types of URL</i></a>
 * <p>
 * In general, a URL can be broken into several parts. Consider the
 * following example:
 * <blockquote>
 *
 * <pre>
 *     http://www.example.com/docs/resource1.html
 * </pre>
 *
 * </blockquote>
 * <p>
 * The URL above indicates that the protocol to use is
 * {@code http} (HyperText Transfer Protocol) and that the
 * information resides on a host machine named
 * {@code www.example.com}. The information on that host
 * machine is named {@code /docs/resource1.html}. The exact
 * meaning of this name on the host machine is both protocol
 * dependent and host dependent. The information normally resides in
 * a file, but it could be generated on the fly. This component of
 * the URL is called the <i>path</i> component.
 * <p>
 * A URL can optionally specify a "port", which is the
 * port number to which the TCP connection is made on the remote host
 * machine. If the port is not specified, the default port for
 * the protocol is used instead. For example, the default port for
 * {@code http} is {@code 80}. An alternative port could be
 * specified as:
 * <blockquote>
 *
 * <pre>
 *     http://www.example.com:1080/docs/resource1.html
 * </pre>
 *
 * </blockquote>
 * <p>
 * The syntax of {@code URL} is defined by <a
 * href="http://www.ietf.org/rfc/rfc2396.txt"><i>RFC&nbsp;2396: Uniform
 * Resource Identifiers (URI): Generic Syntax</i></a>, amended by <a
 * href="http://www.ietf.org/rfc/rfc2732.txt"><i>RFC&nbsp;2732: Format for
 * Literal IPv6 Addresses in URLs</i></a>. The Literal IPv6 address format
 * also supports scope_ids. The syntax and usage of scope_ids is described
 * <a href="Inet6Address.html#scoped">here</a>.
 * <p>
 * A URL may have appended to it a "fragment", also known
 * as a "ref" or a "reference". The fragment is indicated by the sharp
 * sign character "#" followed by more characters. For example,
 * <blockquote>
 *
 * <pre>
 *     http://java.sun.com/index.html#chapter1
 * </pre>
 *
 * </blockquote>
 * <p>
 * This fragment is not technically part of the URL. Rather, it
 * indicates that after the specified resource is retrieved, the
 * application is specifically interested in that part of the
 * document that has the tag {@code chapter1} attached to it. The
 * meaning of a tag is resource specific.
 * <p>
 * An application can also specify a "relative URL",
 * which contains only enough information to reach the resource
 * relative to another URL. Relative URLs are frequently used within
 * HTML pages. For example, if the contents of the URL:
 * <blockquote>
 *
 * <pre>
 *     http://java.sun.com/index.html
 * </pre>
 *
 * </blockquote>
 * contained within it the relative URL:
 * <blockquote>
 *
 * <pre>
 * FAQ.html
 * </pre>
 *
 * </blockquote>
 * it would be a shorthand for:
 * <blockquote>
 *
 * <pre>
 *     http://java.sun.com/FAQ.html
 * </pre>
 *
 * </blockquote>
 * <p>
 * The relative URL need not specify all the components of a URL. If
 * the protocol, host name, or port number is missing, the value is
 * inherited from the fully specified URL. The file component must be
 * specified. The optional fragment is not inherited.
 * <p>
 * The URL class does not itself encode or decode any URL components
 * according to the escaping mechanism defined in RFC2396. It is the
 * responsibility of the caller to encode any fields, which need to be
 * escaped prior to calling URL, and also to decode any escaped fields,
 * that are returned from URL. Furthermore, because URL has no knowledge
 * of URL escaping, it does not recognise equivalence between the encoded
 * or decoded form of the same URL. For example, the two URLs:
 *
 * <pre>
 *     http://foo.com/hello world/ and http://foo.com/hello%20world
 * </pre>
 *
 * would be considered not equal to each other.
 * <p>
 * Note, the {@link java.net.URI} class does perform escaping of its
 * component fields in certain circumstances. The recommended way
 * to manage the encoding and decoding of URLs is to use {@link java.net.URI},
 * and to convert between these two classes using {@link #toURI()} and
 * {@link URI#toURL()}.
 * <p>
 * The {@link java.net.URLEncoder} and {@link java.net.URLDecoder} classes can also be
 * used, but only for HTML form encoding, which is not the same
 * as the encoding scheme defined in RFC2396.
 *
 * @author James Gosling
 * @since JDK1.0
 */
public final class ComplexJavaDocTag implements java.io.Serializable {

	static final String BUILTIN_HANDLERS_PREFIX = "sun.net.www.protocol";
	static final long serialVersionUID = -7627629688361524110L;

	/**
	 * The property which specifies the package prefix list to be scanned
	 * for protocol handlers. The value of this property (if any) should
	 * be a vertical bar delimited list of package names to search through
	 * for a protocol handler to load. The policy of this class is that
	 * all protocol handlers will be in a class called <protocolname>.Handler,
	 * and each package in the list is examined in turn for a matching
	 * handler. If none are found (or the property is not specified), the
	 * default package prefix, sun.net.www.protocol, is used. The search
	 * proceeds from the first package in the list to the last and stops
	 * when a match is found.
	 */
	private static final String protocolPathProp = "java.protocol.handler.pkgs";

	/**
	 * The protocol to use (ftp, http, nntp, ... etc.) .
	 *
	 * @serial
	 */
	private String protocol;

	/**
	 * The host name to connect to.
	 *
	 * @serial
	 */
	private String host;

	/**
	 * The protocol port to connect to.
	 *
	 * @serial
	 */
	private int port = -1;

	/**
	 * The specified file name on that host. {@code file} is
	 * defined as {@code path[?query]}
	 *
	 * @serial
	 */
	private String file;

	/**
	 * The query part of this URL.
	 */
	private transient String query;

	/**
	 * The authority part of this URL.
	 *
	 * @serial
	 */
	private String authority;

	/**
	 * The path part of this URL.
	 */
	private transient String path;

	/**
	 * The userinfo part of this URL.
	 */
	private transient String userInfo;

	/**
	 * # reference.
	 *
	 * @serial
	 */
	private String ref;

	/*
	 * Our hash code.
	 *
	 * @serial
	 */
	private int hashCode = -1;



	/**
	 * Creates a {@code URL} object from the specified
	 * {@code protocol}, {@code host}, {@code port}
	 * number, and {@code file}.
	 * <p>
	 * {@code host} can be expressed as a host name or a literal
	 * IP address. If IPv6 literal address is used, it should be
	 * enclosed in square brackets ({@code '['} and {@code ']'}), as
	 * specified by <a
	 * href="http://www.ietf.org/rfc/rfc2732.txt">RFC&nbsp;2732</a>;
	 * However, the literal IPv6 address format defined in <a
	 * href="http://www.ietf.org/rfc/rfc2373.txt"><i>RFC&nbsp;2373: IP
	 * Version 6 Addressing Architecture</i></a> is also accepted.
	 * <p>
	 * Specifying a {@code port} number of {@code -1}
	 * indicates that the URL should use the default port for the
	 * protocol.
	 * <p>
	 * If this is the first URL object being created with the specified
	 * protocol, a <i>stream protocol handler</i> object, an instance of
	 * class {@code URLStreamHandler}, is created for that protocol:
	 * <ol>
	 * <li>If the application has previously set up an instance of
	 * {@code URLStreamHandlerFactory} as the stream handler factory,
	 * then the {@code createURLStreamHandler} method of that instance
	 * is called with the protocol string as an argument to create the
	 * stream protocol handler.</li>
	 * <li>If no {@code URLStreamHandlerFactory} has yet been set up,
	 * or if the factory's {@code createURLStreamHandler} method
	 * returns {@code null}, then the constructor finds the
	 * value of the system property:</li>
	 *</ol>

	 * <pre>
	 * java.protocol.handler.pkgs
	 *</pre>
	 *
     *
	 * If the value of that system property is not {@code null},
	 * it is interpreted as a list of packages separated by a vertical
	 * slash character '{@code |}'. The constructor tries to load
	 * the class named:
	 *
	 * <pre>
	 *         &lt;<i>package</i>&gt;.&lt;<i>protocol</i>&gt;.Handler
	 *
	 * </pre>
	 *
	 * where &lt;<i>package</i>&gt; is replaced by the name of the package
	 * and &lt;<i>protocol</i>&gt; is replaced by the name of the protocol.
	 * If this class does not exist, or if the class exists but it is not
	 * a subclass of {@code URLStreamHandler}, then the next package
	 * in the list is tried.
	 * <ol>
	 * <li>If the previous step fails to find a protocol handler, then the
	 * constructor tries to load from a system default package.</li>
	 * </ol>
	 * <blockquote>
	 *
	 * <pre>
	 *         &lt;<i>system default package</i>&gt;.&lt;<i>protocol</i>&gt;.Handler
	 * </pre>
	 *
	 * </blockquote>
	 * If this class does not exist, or if the class exists but it is not a
	 * subclass of {@code URLStreamHandler}, then a
	 * {@code MalformedURLException} is thrown.
	 * <p>
	 * Protocol handlers for the following protocols are guaranteed
	 * to exist on the search path :-
	 * <blockquote>
	 *
	 * <pre>
	 *     http, https, file, and jar
	 * </pre>
	 *
	 * </blockquote>
	 * Protocol handlers for additional protocols may also be
	 * available.
	 * <p>
	 * No validation of the inputs is performed by this constructor.
	 *
	 * @param protocol the name of the protocol to use.
	 * @param host the name of the host.
	 * @param port the port number on the host.
	 * @param file the file on the host
	 * @exception MalformedURLException if an unknown protocol is specified.
	 * @see System#getProperty(java.lang.String)
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag#setURLStreamHandlerFactory(
	 * java.net.URLStreamHandlerFactory)
	 * @see java.net.URLStreamHandler
	 * @see java.net.URLStreamHandlerFactory#createURLStreamHandler(
	 * java.lang.String)
	 */
	public ComplexJavaDocTag( String protocol, String host, int port, String file )
			throws MalformedURLException {
		this( protocol, host, port, file, null );
	}

	/**
	 * Creates a URL from the specified {@code protocol}
	 * name, {@code host} name, and {@code file} name. The
	 * default port for the specified protocol is used.
	 * <p>
	 * This method is equivalent to calling the four-argument
	 * constructor with the arguments being {@code protocol},
	 * {@code host}, {@code -1}, and {@code file}.
	 * No validation of the inputs is performed by this constructor.
	 *
	 * @param protocol the name of the protocol to use.
	 * @param host the name of the host.
	 * @param file the file on the host.
	 * @exception MalformedURLException if an unknown protocol is specified.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag#ComplexJavaDocTag(java.lang.String, java.lang.String,
	 * int, java.lang.String)
	 */
	public ComplexJavaDocTag( String protocol, String host, String file )
			throws MalformedURLException {
		this( protocol, host, -1, file );
	}

	/**
	 * Creates a {@code URL} object from the specified
	 * {@code protocol}, {@code host}, {@code port}
	 * number, {@code file}, and {@code handler}. Specifying
	 * a {@code port} number of {@code -1} indicates that
	 * the URL should use the default port for the protocol. Specifying
	 * a {@code handler} of {@code null} indicates that the URL
	 * should use a default stream handler for the protocol, as outlined
	 * for:
	 * java.net.URL#URL(java.lang.String, java.lang.String, int,
	 * java.lang.String)
	 * <p>
	 * If the handler is not null and there is a security manager,
	 * the security manager's {@code checkPermission}
	 * method is called with a
	 * {@code NetPermission("specifyStreamHandler")} permission.
	 * This may result in a SecurityException.
	 * No validation of the inputs is performed by this constructor.
	 *
	 * @param protocol the name of the protocol to use.
	 * @param host the name of the host.
	 * @param port the port number on the host.
	 * @param file the file on the host
	 * @param handler the stream handler for the URL.
	 * @exception MalformedURLException if an unknown protocol is specified.
	 * @exception SecurityException
	 * if a security manager exists and its
	 * {@code checkPermission} method doesn't allow
	 * specifying a stream handler explicitly.
	 * @see java.lang.System#getProperty(java.lang.String)
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag#setURLStreamHandlerFactory(
	 * java.net.URLStreamHandlerFactory)
	 * @see java.net.URLStreamHandlerFactory#createURLStreamHandler(
	 * java.lang.String)
	 * @see SecurityManager#checkPermission
	 * @see java.net.NetPermission
	 */
	public ComplexJavaDocTag( String protocol,
			String host,
			int port,
			String file,
			URLStreamHandler handler ) throws MalformedURLException {

	}

	/**
	 * Creates a {@code URL} object from the {@code String}
	 * representation.
	 * <p>
	 * This constructor is equivalent to a call to the two-argument
	 * constructor with a {@code null} first argument.
	 *
	 * @param spec the {@code String} to parse as a URL.
	 * @exception MalformedURLException if no protocol is specified, or an
	 * unknown protocol is found, or {@code spec} is {@code null}.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag
	 */
	public ComplexJavaDocTag( String spec ) throws MalformedURLException {
		this( null, spec );
	}

	/**
	 * Creates a URL by parsing the given spec within a specified context.
	 * The new URL is created from the given context URL and the spec
	 * argument as described in
	 * RFC2396 &quot;Uniform Resource Identifiers : Generic * Syntax&quot; :
	 * <blockquote>
	 *
	 * <pre>
	 *          &lt;scheme&gt;://&lt;authority&gt;&lt;path&gt;?&lt;query&gt;#&lt;fragment&gt;
	 * </pre>
	 *
	 * </blockquote>
	 * The reference is parsed into the scheme, authority, path, query and
	 * fragment parts. If the path component is empty and the scheme,
	 * authority, and query components are undefined, then the new URL is a
	 * reference to the current document. Otherwise, the fragment and query
	 * parts present in the spec are used in the new URL.
	 * <p>
	 * If the scheme component is defined in the given spec and does not match
	 * the scheme of the context, then the new URL is created as an absolute
	 * URL based on the spec alone. Otherwise the scheme component is inherited
	 * from the context URL.
	 * <p>
	 * If the authority component is present in the spec then the spec is
	 * treated as absolute and the spec authority and path will replace the
	 * context authority and path. If the authority component is absent in the
	 * spec then the authority of the new URL will be inherited from the
	 * context.
	 * <p>
	 * If the spec's path component begins with a slash character
	 * &quot;/&quot; then the
	 * path is treated as absolute and the spec path replaces the context path.
	 * <p>
	 * Otherwise, the path is treated as a relative path and is appended to the
	 * context path, as described in RFC2396. Also, in this case,
	 * the path is canonicalized through the removal of directory
	 * changes made by occurrences of &quot;..&quot; and &quot;.&quot;.
	 * <p>
	 * For a more detailed description of URL parsing, refer to RFC2396.
	 *
	 * @param context the context in which to parse the specification.
	 * @param spec the {@code String} to parse as a URL.
	 * @exception MalformedURLException if no protocol is specified, or an
	 * unknown protocol is found, or {@code spec} is {@code null}.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag
	 * @see java.net.URLStreamHandler
	 * @see java.net.URLStreamHandler#parseURL
	 */
	public ComplexJavaDocTag( ComplexJavaDocTag context, String spec ) throws MalformedURLException {
		this( context, spec, null );
	}

	/**
	 * Creates a URL by parsing the given spec with the specified handler
	 * within a specified context. If the handler is null, the parsing
	 * occurs as with the two argument constructor.
	 *
	 * @param context the context in which to parse the specification.
	 * @param spec the {@code String} to parse as a URL.
	 * @param handler the stream handler for the URL.
	 * @exception MalformedURLException if no protocol is specified, or an
	 * unknown protocol is found, or {@code spec} is {@code null}.
	 * @exception SecurityException
	 * if a security manager exists and its
	 * {@code checkPermission} method doesn't allow
	 * specifying a stream handler.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag
	 * @see java.net.URLStreamHandler
	 * @see java.net.URLStreamHandler#parseURL
	 */
	public ComplexJavaDocTag( ComplexJavaDocTag context, String spec, URLStreamHandler handler )
			throws MalformedURLException {

	}

	/*
	 * Returns true if specified string is a valid protocol name.
	 */
	private boolean isValidProtocol( String protocol ) {
		int len = protocol.length();
		if ( len < 1 )
			return false;
		char c = protocol.charAt( 0 );
		if ( !Character.isLetter( c ) )
			return false;
		for ( int i = 1; i < len; i++ ) {
			c = protocol.charAt( i );
			if ( !Character.isLetterOrDigit( c ) && c != '.' && c != '+' &&
					c != '-' ) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Checks for permission to specify a stream handler.
	 */
	private void checkSpecifyHandler( SecurityManager sm ) {

	}

	/**
	 * Sets the fields of the URL. This is not a public method so that
	 * only URLStreamHandlers can modify URL fields. URLs are
	 * otherwise constant.
	 *
	 * @param protocol the name of the protocol to use
	 * @param host the name of the host
	 * @param port the port number on the host
	 * @param file the file on the host
	 * @param ref the internal reference in the URL
	 */
	void set( String protocol, String host, int port,
			String file, String ref ) {

	}

	/**
	 * Sets the specified 8 fields of the URL. This is not a public method so
	 * that only URLStreamHandlers can modify URL fields. URLs are otherwise
	 * constant.
	 *
	 * @param protocol the name of the protocol to use
	 * @param host the name of the host
	 * @param port the port number on the host
	 * @param authority the authority part for the url
	 * @param userInfo the username and password
	 * @param path the file on the host
	 * @param ref the internal reference in the URL
	 * @param query the query part of this URL
	 * @since 1.3
	 */
	void set( String protocol, String host, int port,
			String authority, String userInfo, String path,
			String query, String ref ) {
		synchronized ( this ) {
			this.protocol = protocol;
			this.host = host;
			this.port = port;
			this.file = query == null ? path : path + "?" + query;
			this.userInfo = userInfo;
			this.path = path;
			this.ref = ref;
			/*
			 * This is very important. We must recompute this after the
			 * URL has been changed.
			 */
			hashCode = -1;

			this.query = query;
			this.authority = authority;
		}
	}

	/**
	 * Gets the query part of this {@code URL}.
	 *
	 * @return the query part of this {@code URL},
	 * or <CODE>null</CODE> if one does not exist
	 * @since 1.3
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * Gets the path part of this {@code URL}.
	 *
	 * @return the path part of this {@code URL}, or an
	 * empty string if one does not exist
	 * @since 1.3
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Gets the userInfo part of this {@code URL}.
	 *
	 * @return the userInfo part of this {@code URL}, or
	 * <CODE>null</CODE> if one does not exist
	 * @since 1.3
	 */
	public String getUserInfo() {
		return userInfo;
	}

	/**
	 * Gets the authority part of this {@code URL}.
	 *
	 * @return the authority part of this {@code URL}
	 * @since 1.3
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * Gets the port number of this {@code URL}.
	 *
	 * @return the port number, or -1 if the port is not set
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Gets the default port number of the protocol associated
	 * with this {@code URL}. If the URL scheme or the URLStreamHandler
	 * for the URL do not define a default port number,
	 * then -1 is returned.
	 *
	 * @return the port number
	 * @since 1.4
	 */
	public int getDefaultPort() {
		return 0;
	}

	/**
	 * Gets the protocol name of this {@code URL}.
	 *
	 * @return the protocol of this {@code URL}.
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 * Gets the host name of this {@code URL}, if applicable.
	 * The format of the host conforms to RFC 2732, i.e. for a
	 * literal IPv6 address, this method will return the IPv6 address
	 * enclosed in square brackets ({@code '['} and {@code ']'}).
	 *
	 * @return the host name of this {@code URL}.
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Gets the file name of this {@code URL}.
	 * The returned file portion will be
	 * the same as <CODE>getPath()</CODE>, plus the concatenation of
	 * the value of <CODE>getQuery()</CODE>, if any. If there is
	 * no query portion, this method and <CODE>getPath()</CODE> will
	 * return identical results.
	 *
	 * @return the file name of this {@code URL},
	 * or an empty string if one does not exist
	 */
	public String getFile() {
		return file;
	}

	/**
	 * Gets the anchor (also known as the "reference") of this
	 * {@code URL}.
	 *
	 * @return the anchor (also known as the "reference") of this
	 * {@code URL}, or <CODE>null</CODE> if one does not exist
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * Compares this URL for equality with another object.
	 * <p>
	 * If the given object is not a URL then this method immediately returns
	 * {@code false}.
	 * <p>
	 * Two URL objects are equal if they have the same protocol, reference
	 * equivalent hosts, have the same port number on the host, and the same
	 * file and fragment of the file.
	 * <p>
	 * Two hosts are considered equivalent if both host names can be resolved
	 * into the same IP addresses; else if either host name can't be
	 * resolved, the host names must be equal without regard to case; or both
	 * host names equal to null.
	 * <p>
	 * Since hosts comparison requires name resolution, this operation is a
	 * blocking operation.
	 * <p>
	 * Note: The defined behavior for {@code equals} is known to
	 * be inconsistent with virtual hosting in HTTP.
	 *
	 * @param obj the URL to compare against.
	 * @return {@code true} if the objects are the same;
	 * {@code false} otherwise.
	 */
	public boolean equals( Object obj ) {
		return false;
	}

	/**
	 * Creates an integer suitable for hash table indexing.
	 * <p>
	 * The hash code is based upon all the URL components relevant for URL
	 * comparison. As such, this operation is a blocking operation.
	 * <p>
	 *
	 * @return a hash code for this {@code URL}.
	 */
	public synchronized int hashCode() {
		return 0;
	}

	/**
	 * Compares two URLs, excluding the fragment component.
	 * <p>
	 * Returns {@code true} if this {@code URL} and the
	 * {@code other} argument are equal without taking the
	 * fragment component into consideration.
	 *
	 * @param other the {@code URL} to compare against.
	 * @return {@code true} if they reference the same remote object;
	 * {@code false} otherwise.
	 */
	public boolean sameFile( ComplexJavaDocTag other ) {
		return false;
	}

	/**
	 * Constructs a string representation of this {@code URL}. The
	 * string is created by calling the {@code toExternalForm}
	 * method of the stream protocol handler for this object.
	 *
	 * @return a string representation of this object.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag#ComplexJavaDocTag(String, String, int, String)
	 * @see java.net.URLStreamHandler#toExternalForm
	 */
	public String toString() {
		return toExternalForm();
	}

	/**
	 * Constructs a string representation of this {@code URL}. The
	 * string is created by calling the {@code toExternalForm}
	 * method of the stream protocol handler for this object.
	 *
	 * @return a string representation of this object.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag#ComplexJavaDocTag(String, String, int, String)
	 * @see java.net.URLStreamHandler#toExternalForm
	 */
	public String toExternalForm() {
		return null;
	}

	/**
	 * Returns a {@link java.net.URI} equivalent to this URL.
	 * This method functions in the same way as {@code new URI (this.toString())}.
	 * <p>
	 * Note, any URL instance that complies with RFC 2396 can be converted
	 * to a URI. However, some URLs that are not strictly in compliance
	 * can not be converted to a URI.
	 *
	 * @exception URISyntaxException if this URL is not formatted strictly according to
	 * to RFC2396 and cannot be converted to a URI.
	 * @return a URI instance equivalent to this URL.
	 * @since 1.5
	 */
	public URI toURI() throws URISyntaxException {
		return new URI( toString() );
	}

	/**
	 * Returns a {@link java.net.URLConnection URLConnection} instance that
	 * represents a connection to the remote object referred to by the
	 * {@code URL}.
	 * <P>
	 * A new instance of {@linkplain java.net.URLConnection URLConnection} is
	 * created every time when invoking the
	 * {@linkplain java.net.URLStreamHandler#openConnection}
	 * URLStreamHandler.openConnection(URL)} method of the protocol handler for
	 * this URL.
	 * </P>
	 * <P>
	 * It should be noted that a URLConnection instance does not establish
	 * the actual network connection on creation. This will happen only when
	 * calling {@linkplain java.net.URLConnection#connect() URLConnection.connect()}.
	 * </P>
	 * <P>
	 * If for the URL's protocol (such as HTTP or JAR), there
	 * exists a public, specialized URLConnection subclass belonging
	 * to one of the following packages or one of their subpackages:
	 * java.lang, java.io, java.util, java.net, the connection
	 * returned will be of that subclass. For example, for HTTP an
	 * HttpURLConnection will be returned, and for JAR a
	 * JarURLConnection will be returned.
	 * </P>
	 *
	 * @return a {@link java.net.URLConnection URLConnection} linking
	 * to the URL.
	 * @exception IOException if an I/O exception occurs.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag
	 */
	public URLConnection openConnection() throws java.io.IOException {
		return  null;
	}

	/**
	 * Same as {@link #openConnection()}, except that the connection will be
	 * made through the specified proxy; Protocol handlers that do not
	 * support proxing will ignore the proxy parameter and make a
	 * normal connection.
	 * Invoking this method preempts the system's default ProxySelector
	 * settings.
	 *
	 * @param proxy the Proxy through which this connection
	 * will be made. If direct connection is desired,
	 * Proxy.NO_PROXY should be specified.
	 * @return a {@code URLConnection} to the URL.
	 * @exception IOException if an I/O exception occurs.
	 * @exception SecurityException if a security manager is present
	 * and the caller doesn't have permission to connect
	 * to the proxy.
	 * @exception IllegalArgumentException will be thrown if proxy is null,
	 * or proxy has the wrong type
	 * @exception UnsupportedOperationException if the subclass that
	 * implements the protocol handler doesn't support
	 * this method.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag
	 * @see java.net.URLConnection
	 * @see java.net.URLStreamHandler#openConnection
	 * @since 1.5
	 */
	public URLConnection openConnection( Proxy proxy )
			throws java.io.IOException {
	return null;
	}

	/**
	 * Opens a connection to this {@code URL} and returns an
	 * {@code InputStream} for reading from that connection. This
	 * method is a shorthand for:
	 * <blockquote>
	 *
	 * <pre>
	 * openConnection().getInputStream()
	 * </pre>
	 *
	 * </blockquote>
	 *
	 * @return an input stream for reading from the URL connection.
	 * @exception IOException if an I/O exception occurs.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag#openConnection()
	 * @see java.net.URLConnection#getInputStream()
	 */
	public final InputStream openStream() throws java.io.IOException {
		return null;
	}

	/**
	 * Gets the contents of this URL. This method is a shorthand for:
	 * <blockquote>
	 *
	 * <pre>
	 * openConnection().getContent()
	 * </pre>
	 *
	 * </blockquote>
	 *
	 * @return the contents of this URL.
	 * @exception IOException if an I/O exception occurs.
	 * @see java.net.URLConnection#getContent()
	 */
	public final Object getContent() throws java.io.IOException {
		return openConnection().getContent();
	}

	/**
	 * Gets the contents of this URL. This method is a shorthand for:
	 * <blockquote>
	 *
	 * <pre>
	 *     openConnection().getContent(Class[])
	 * </pre>
	 *
	 * </blockquote>
	 *
	 * @param classes an array of Java types
	 * @return the content object of this URL that is the first match of
	 * the types specified in the classes array.
	 * null if none of the requested types are supported.
	 * @exception IOException if an I/O exception occurs.
	 * @see java.net.URLConnection#getContent(Class[])
	 * @since 1.3
	 */
	public final Object getContent( Class[] classes )
			throws java.io.IOException {
		return null;
	}

	/**
	 * The URLStreamHandler factory.
	 */
	static URLStreamHandlerFactory factory;

	/**
	 * Sets an application's {@code URLStreamHandlerFactory}.
	 * This method can be called at most once in a given Java Virtual
	 * Machine.
	 * <p>
	 * The {@code URLStreamHandlerFactory} instance is used to
	 * construct a stream protocol handler from a protocol name.
	 * <p>
	 * If there is a security manager, this method first calls
	 * the security manager's {@code checkSetFactory} method
	 * to ensure the operation is allowed.
	 * This could result in a SecurityException.
	 *
	 * @param fac the desired factory.
	 * @exception Error if the application has already set a factory.
	 * @exception SecurityException if a security manager exists and its
	 * {@code checkSetFactory} method doesn't allow
	 * the operation.
	 * @see it.serendigity.samples.nested.ComplexJavaDocTag
	 * @see java.net.URLStreamHandlerFactory
	 * @see SecurityManager#checkSetFactory
	 */
	public static void setURLStreamHandlerFactory( URLStreamHandlerFactory fac ) {

	}

	/**
	 * Returns the Stream Handler.
	 *
	 * @param protocol the protocol to use
	 */
	static URLStreamHandler getURLStreamHandler( String protocol ) {

		return null;

	}

	/**
	 * WriteObject is called to save the state of the URL to an
	 * ObjectOutputStream. The handler is not saved since it is
	 * specific to this system.
	 *
	 * @serialData the default write object value. When read back in,
	 * the reader must ensure that calling getURLStreamHandler with
	 * the protocol variable returns a valid URLStreamHandler and
	 * throw an IOException if it does not.
	 * @param s - parameter
	 * @throws IOException IOException if it does not.
	 */
	private synchronized void writeObject( java.io.ObjectOutputStream s )
			throws IOException {
		s.defaultWriteObject(); // write the fields
	}

}
