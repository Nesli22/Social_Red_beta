package modelo.Configuracion;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.bson.types.ObjectId;

/**
 *
 * @author Rodrigo Gtz
 */
public class ObjectIdAdapter  extends TypeAdapter<ObjectId> {

     @Override
    public void write(JsonWriter out, ObjectId value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.toHexString());
        }
    }

    @Override
    public ObjectId read(JsonReader in) throws IOException {
        if (in.peek() == null) {
            in.nextNull();
            return null;
        } else {
            String objectIdStr = in.nextString();
            return new ObjectId(objectIdStr);
        }
    }
}
