package com.tutego.exercises.jsp;

/**
 *  Simple voting class.
 *  
 *  @author Ulli.
 */
public class Voting
{
  /**
   * An array for alle votings.  
   */
  private long[] votes = new long[5];

  /**
   * Initializes votes for all values.
   * 
   * @param v1 Votings for Rating 1
   * @param v2 Votings for Rating 2
   * @param v3 Votings for Rating 3
   * @param v4 Votings for Rating 4
   * @param v5 Votings for Rating 5
   */
  public void setVotes( long v1, long v2, long v3, long v4, long v5 )
  {
    votes[0] = v1;
    votes[1] = v2;
    votes[2] = v3;
    votes[3] = v4;
    votes[4] = v5;
  }

  /**
   * Votes for a given rank.
   * 
   * @param vote Item to vote for (1-5)
   */
  public void setVotesFor( int vote )
  {
    if ( vote >= 1 && vote <= 5 )
      votes[vote - 1]++;
  }

  /**
   * @return Number of votes for a given rank.
   */
  public long getVotesFor( int vote )
  {
    if ( vote >= 1 && vote <= 5 )
      return votes[vote - 1];

  return 0; 
  }

  public long getVotesFor1()
  {
    return getVotesFor( 1 );
  }
  public long getVotesFor2()
  {
    return getVotesFor( 2 );
  }
  public long getVotesFor3()
  {
    return getVotesFor( 3 );
  }
  public long getVotesFor4()
  {
    return getVotesFor( 4 );
  }
  public long getVotesFor5()
  {
    return getVotesFor( 5 );
  }

  public int getVotesFor1Percentage()
  {
    return getPercentage( getVotesFor(1) );
  }
  public int getVotesFor2Percentage()
  {
    return getPercentage( getVotesFor(2) );
  }
  public int getVotesFor3Percentage()
  {
    return getPercentage( getVotesFor(3) );
  }
  public int getVotesFor4Percentage()
  {
    return getPercentage( getVotesFor(4) );
  }
  public int getVotesFor5Percentage()
  {
    return getPercentage( getVotesFor(5) );
  }

  /**
   * @return Average of all votes.
   */
  public double getAverage()
  {
    return (double)(votes[0] + 2*votes[1] + 3*votes[2] + 4*votes[3] + 5*votes[4] ) / getAllVotes();
  }

  /**
   * @return Count of all votes.
   */
  public long getAllVotes()
  {
    return votes[0] + votes[1] + votes[2] + votes[3] + votes[4];
  }

  private int getPercentage( double val )
  {
    return (int)( val * 100 / getAllVotes() );
  } 
}
