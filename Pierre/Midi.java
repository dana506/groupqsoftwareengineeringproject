import javax.sound.midi.*;
import java.io.File;

public class Midi {


    /**
     * Plays a Midi File
     * @author  David Wakeling
     * @param filePath path to the Midi file to play
     */
    public static void play(String filePath) {
        try {
            final Sequencer sequen = MidiSystem.getSequencer();
            final Transmitter trans = sequen.getTransmitter();

            sequen.open();

            sequen.setSequence(MidiSystem.getSequence(new File(filePath)));

            // trans.setReceiver( new Display() );

            sequen.addMetaEventListener(new MetaEventListener() {
                public void meta(MetaMessage mesg) {
                    if (mesg.getType() == 0x2F /* end-of-track */) {
                        sequen.close();
                    }
                }
            });

            sequen.start();
        } catch (Exception exn) {
            System.out.println(exn);
            System.exit(1);
        }
    }

    /**
     * Plays a plays on track from a midi file
     * @author  Pierre
     * @param filePath path to the Midi file to play
     * @param trackID track to play
     */
        public static void playTrack(String filePath, int trackID){
            try {
                final Sequencer   sequen = MidiSystem.getSequencer();
                final Transmitter trans  = sequen.getTransmitter();

                sequen.open();

                sequen.setSequence( MidiSystem.getSequence( new File( filePath ) ) );
                sequen.setTrackSolo(trackID, true);
                if (!sequen.getTrackSolo(trackID)) {
                    System.out.println("Track doesn't exist");
                    return;
                }
                // trans.setReceiver( new Display() );

                sequen.addMetaEventListener( new MetaEventListener() {
                    public void meta( MetaMessage mesg ) {
                        if ( mesg.getType() == 0x2F /* end-of-track */ ) {
                            sequen.close();
                        }
                    }
                });

                sequen.start();
            } catch ( Exception exn ) {
                System.out.println( exn ); System.exit( 1 );
            }
            }
    /**
     *Isolates a midi track
     * @author  Pierre
     * @param filePath path to the Midi file to play
     * @param trackID the track to isolates
     */
            public static File setTrack(String filePath, int trackID){
            try {
                final Sequencer   sequen = MidiSystem.getSequencer();
                final Transmitter trans  = sequen.getTransmitter();

                sequen.open();

                sequen.setSequence( MidiSystem.getSequence( new File( filePath ) ) );
                Track Tracks[] = sequen.getSequence().getTracks();
                for (int i = 0; i <16 ; i++) {
                    if (i != trackID-1) {
                        sequen.getSequence().deleteTrack(Tracks[i]);
                    }

                }
                sequen.setTrackSolo(trackID, true);
                if (!sequen.getTrackSolo(trackID)) {
                    System.out.println("Track doesn't exist");
                    return null;
                }
                // trans.setReceiver( new Display() );

                sequen.addMetaEventListener( new MetaEventListener() {
                    public void meta( MetaMessage mesg ) {
                        if ( mesg.getType() == 0x2F /* end-of-track */ ) {
                            sequen.close();
                        }
                    }
                });

                File soloTrack = new File("solotrack.mid");
                MidiSystem.write(sequen.getSequence(),1, soloTrack);
                sequen.close();
                return soloTrack;
            } catch ( Exception exn ) {
                System.out.println( exn ); System.exit( 1 );
            }

                return null;
            }

/*    public static void stopPlaying(){
        try {
            final Sequencer sequen = MidiSystem.getSequencer();
            final Transmitter trans = sequen.getTransmitter();
            Sequence dummy = new Sequence(Sequence.PPQ, 10);
            sequen.open();
            sequen.setSequence(dummy);
            sequen.start();
            sequen.close();*//*
            sequen.setSequence(MidiSystem.getSequence(new File(filePath)));

            // trans.setReceiver( new Display() );

            sequen.addMetaEventListener(new MetaEventListener() {
                public void meta(MetaMessage mesg) {
                    if (mesg.getType() == 0x2F *//**//* end-of-track *//**//*) {
                        sequen.close();
                    }
                }
            });

            sequen.start();*//*
        } catch (Exception exn) {
            System.out.println(exn);
            System.exit(1);
        }
    }*/






}
