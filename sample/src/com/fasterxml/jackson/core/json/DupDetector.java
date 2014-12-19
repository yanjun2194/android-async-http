package com.fasterxml.jackson.core.json;

import java.util.*;

import com.fasterxml.jackson.core.*;

/**
 * Helper class used if
 * {@link com.fasterxml.jackson.core.JsonParser.Feature#STRICT_DUPLICATE_DETECTION}
 * is enabled.
 * Optimized to try to limit memory usage and processing overhead for smallest
 * entries, but without adding trashing (immutable objects would achieve optimal
 * memory usage but lead to significant number of discarded temp objects for
 * scopes with large number of entries). Another consideration is trying to limit
 * actual number of compiled classes as it contributes significantly to overall
 * jar size (due to linkage etc).
 * 
 * @since 2.3
 */
public class DupDetector
{
    /**
     * We need to store a back-reference here to parser/generator, unfortunately.
     */
    protected final Object _source;

    protected String _firstName;

    protected String _secondName;
    
    /**
     * Lazily constructed set of names already seen within this context.
     */
    protected HashSet<String> _seen;

    private DupDetector(Object src) {
        _source = src;
    }

    public static DupDetector rootDetector(JsonParser p) {
        return new DupDetector(p);
    }

    public static DupDetector rootDetector(JsonGenerator g) {
        return new DupDetector(g);
    }
    
    public DupDetector child() {
        return new DupDetector(_source);
    }

    public void reset() {
        _firstName = null;
        _secondName = null;
        _seen = null;
    }

    public JsonLocation findLocation() {
        // ugly but:
        if (_source instanceof JsonParser) {
            return ((JsonParser)_source).getCurrentLocation();
        }
        // do generators have a way to provide Location? Apparently not...
        return null;
    }
    
    public boolean isDup(String name) throws JsonParseException
    {
        if (_firstName == null) {
            _firstName = name;
            return false;
        }
        if (name.equals(_firstName)) {
            return true;
        }
        if (_secondName == null) {
            _secondName = name;
            return false;
        }
        if (name.equals(_secondName)) {
            return true;
        }
        if (_seen == null) {
            _seen = new HashSet<String>(16); // 16 is default, seems reasonable
            _seen.add(_firstName);
            _seen.add(_secondName);
        }
        return !_seen.add(name);
    }
}
