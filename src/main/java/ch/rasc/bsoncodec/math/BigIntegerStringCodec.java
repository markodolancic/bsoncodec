package ch.rasc.bsoncodec.math;

import java.math.BigInteger;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class BigIntegerStringCodec implements Codec<BigInteger> {

	@Override
	public Class<BigInteger> getEncoderClass() {
		return BigInteger.class;
	}

	@Override
	public void encode(BsonWriter writer, BigInteger value,
			EncoderContext encoderContext) {
		writer.writeString(value.toString());
	}

	@Override
	public BigInteger decode(BsonReader reader, DecoderContext decoderContext) {
		return new BigInteger(reader.readString());
	}

}
