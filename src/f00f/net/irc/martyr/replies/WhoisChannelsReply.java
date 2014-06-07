package f00f.net.irc.martyr.replies;

import f00f.net.irc.martyr.InCommand;
import f00f.net.irc.martyr.util.ParameterIterator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;



public class WhoisChannelsReply extends AbstractWhoisReply
{


    private String channels;

	/**
	 * Factory constructor.
	 * */
	public WhoisChannelsReply()
	{
	}

	public WhoisChannelsReply( String params )
	{
		super( params );
	}

    @Override
	public String getIrcIdentifier()
	{
		return "319";
	}

	/**
	 * @return a space-delimited list of channels
	 * */
	public String getChannels()
	{
		return channels;
	}

	/**
	 * @return a set of Strings of channels
	 * */
	public Set<String> getChannelSet()
	{
		StringTokenizer tokens = new StringTokenizer( channels );
		Set<String> set = new HashSet<>();
		while( tokens.hasMoreTokens() )
		{
			set.add( tokens.nextToken() );
		}

		return set;
	}

    @Override
	protected void parseParams( ParameterIterator pi )
	{
		channels = pi.last(); // Channels


	}

    @Override
	public InCommand parse( String prefix, String identifier, String params )
	{
		return new WhoisChannelsReply( params );
	}

}
