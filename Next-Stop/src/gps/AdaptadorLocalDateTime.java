package gps;

import com.google.gson.TypeAdapter;
import java.time.LocalDateTime;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.time.format.DateTimeFormatter;
public class AdaptadorLocalDateTime  extends TypeAdapter<LocalDateTime> {
    // clase adaptador del LocalDateTime ya que no es compatible con el JSON y con el jdk instalado
        private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        @Override
        public void write(JsonWriter out, LocalDateTime value) throws IOException {
            out.value(value.format(formatter));
        }

        @Override
        public LocalDateTime read(JsonReader in) throws IOException {
            return LocalDateTime.parse(in.nextString(), formatter);
        }
    }


