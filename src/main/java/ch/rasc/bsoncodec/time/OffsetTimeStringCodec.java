/**
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.rasc.bsoncodec.time;

import java.time.OffsetTime;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class OffsetTimeStringCodec implements Codec<OffsetTime> {

	@Override
	public Class<OffsetTime> getEncoderClass() {
		return OffsetTime.class;
	}

	@Override
	public void encode(BsonWriter writer, OffsetTime value,
			EncoderContext encoderContext) {
		writer.writeString(value.toString());
	}

	@Override
	public OffsetTime decode(BsonReader reader, DecoderContext decoderContext) {
		return OffsetTime.parse(reader.readString());
	}

}
