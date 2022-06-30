package Model;

import MsgToClient.MsgToClient;
import MsgToServer.MsgToServer;

import java.util.Arrays;
import java.util.Random;

public class Model {

    int[][][] first_player_fields = new int[2][10][10];
    int[][][] second_player_fields = new int[2][10][10];
    int[] count_of_killed = new int[2];
    int turn = 0;
    boolean[] ready_to_play = new boolean[2];


    public int GetWinner() {
        if (count_of_killed[0] == 10) {
            return 0;
        }
        else {
            return 1;
        }
    }
    public boolean GameIsEnd() {
        return count_of_killed[0] == 10 || count_of_killed[1] == 10;
    }

    public boolean Ready() {
        return this.ready_to_play[0] && this.ready_to_play[1];
    }

    public int[][][] get_fields(int player) {
        if (player == 0) {
            return first_player_fields;
        }
        return second_player_fields;

    }

    public int[][][] getFirst_player_fields() {
        return first_player_fields;
    }

    public int[][][] getSecond_player_fields() {
        return second_player_fields;
    }

    public int[] getCount_of_killed() {
        return count_of_killed;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean[] getReady_to_play() {
        return ready_to_play;
    }

    public void VisualizeField(int[][] field) {
//        int[][] new_field = field.clone(); Eto ne rabotaet blyad
        int[][] new_field = new int[field.length][];
        for (int i = 0; i < field.length; i++) {
            new_field[i] = Arrays.copyOf(field[i], field[i].length);
        }
        char[] mask = new char[]{'.', '@', '#', 'x'};
        char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (int x = -1; x < 10; ++x) {
            if (x == -1) {
                System.out.printf("%4c", ' ');
                continue;
            }
            System.out.printf("%4c", alphabet[x]);
        }
        System.out.println();
        for (int y = 0; y < 10; ++y) {
            for (int x = 0; x < 10; ++x) {
                new_field[y][x] = mask[field[y][x]];
                if (x == 0) {
                    System.out.printf("%4d", y + 1);
                }
                System.out.printf("%4c", new_field[y][x]);
            }
            System.out.println();
        }
    }

    int[][] GenerateRandomField() {
        Random random = new Random();
        int[][] field = new int[10][10];

        int[] counts = new int[]{1, 2, 3, 4};
        int[] lengths = new int[]{4, 3, 2, 1};

        for (int idx = 0; idx < 4; ++idx) {
            int cur_len = lengths[idx];
            int cur_cnt = counts[idx];

            for (int jdx = 0; jdx < cur_cnt; ++jdx) {
                boolean done = false;
                while (!done) {
                    int x = random.nextInt(10);
                    int y = random.nextInt(10);
                    boolean vertical = random.nextBoolean();
                    if (vertical) {
                        if (y + cur_len > 10) {
                            y -= cur_len;
                        }
                    } else if (x + cur_len > 10) {
                        x -= cur_len;
                    }


                    boolean neighbours_at_edges = false;
                    // check for free space
                    if (vertical) {
                        for (int row = y - 1; row < y + cur_len + 1; ++row) {
                            if ((row == -1) || (row == 10)) {
                                continue;
                            }
                            if (field[row][x] != 0) {
                                neighbours_at_edges = true;
                                break;
                            }
                            if (!((x - 1 >= 0) && (field[row][x - 1] == 0))) {
                                neighbours_at_edges = true;
                                break;
                            }
                            if (!((x + 1 < 10) && (field[row][x + 1] == 0))) {
                                neighbours_at_edges = true;
                                break;
                            }
                        }

                    } else {

                        for (int col = x - 1; col < x + cur_len + 1; ++col) {

                            if ((col == -1) || (col == 10)) {
                                continue;
                            }
                            if (field[y][col] != 0) {
                                neighbours_at_edges = true;
                                break;
                            }

                            if (!((y - 1 >= 0) && (field[y - 1][col] == 0))) {
                                neighbours_at_edges = true;
                                break;
                            }
                            if (!((y + 1 < 10) && (field[y + 1][col] == 0))) {
                                neighbours_at_edges = true;
                                break;
                            }
                        }

                    }
                    if (neighbours_at_edges) {  // no free space arround ship
                        continue;
                    }

                    done = true;
                    if (vertical) {
                        for (int row = y; row < y + cur_len; ++row) {
                            field[row][x] = 1;
                        }
                    } else {
                        for (int col = x; col < x + cur_len; ++col) {
                            field[y][col] = 1;
                        }
                    }
                }
            }

        }
        VisualizeField(field);
        return field;
    }


    public MsgToClient ProcessMove(MsgToServer msg) {
        MsgToClient response;
        int[][] myfield;
        int[][] oppsfield;
        if (this.getTurn() == 0) {
            myfield = this.first_player_fields[1];
            oppsfield = this.second_player_fields[0];
        } else {
            myfield = this.second_player_fields[1];
            oppsfield = this.first_player_fields[0];
        }
        String[] message_split = msg.GetMove().split(" ");
        message_split[0] = message_split[0].toUpperCase();
        int[] coords = new int[2];
        coords[1] = message_split[0].toCharArray()[0] - 'A';
        coords[0] = Integer.parseInt(String.valueOf(message_split[1].toCharArray())) - 1;

        if (oppsfield[coords[0]][coords[1]] != 1) {
            myfield[coords[0]][coords[1]] = 3;
            oppsfield[coords[0]][coords[1]] = 3;
            if (this.getTurn() == 0) {
                response = new MsgToClient(this.turn, 3, first_player_fields);
            } else {
                response = new MsgToClient(this.turn, 3, second_player_fields);
            }
            return response;
        }
        int kill_or_hit = ProcessKilledOrHit(coords[0], coords[1], oppsfield);
        myfield[coords[0]][coords[1]] = 2;
        if (kill_or_hit == 0) {
            if (this.getTurn() == 0) {
                response = new MsgToClient(this.turn, 1, first_player_fields);
            } else {
                response = new MsgToClient(this.turn, 1, second_player_fields);
            }
            return response;
        } else {
            this.count_of_killed[this.turn]++;
            if (this.count_of_killed[this.turn] == 10) {
                if (this.getTurn() == 0) {
                    response = new MsgToClient(this.turn, 4, first_player_fields);
                } else {
                    response = new MsgToClient(this.turn, 4, second_player_fields);
                }
                return response;
            }
            if (this.getTurn() == 0) {
                response = new MsgToClient(this.turn, 2, first_player_fields);
            } else {
                response = new MsgToClient(this.turn, 2, second_player_fields);
            }
            return response;
        }
    }

    int ProcessKilledOrHit(int y, int x, int[][] field) {
        boolean vertical = false;
        boolean horizontal = false;
        if (((x + 1 < 10) && ((field[y][x + 1] == 1) || (field[y][x + 1] == 2))) ||
                ((x - 1 >= 0) && ((field[y][x - 1] == 1) || (field[y][x - 1] == 2)))) {
            horizontal = true;
        }

        if (((y + 1 < 10) && ((field[y + 1][x] == 1) || (field[y + 1][x] == 2))) ||
                ((y - 1 >= 0) && ((field[y - 1][x] == 1) || (field[y - 1][x] == 2)))) {
            vertical = true;
        }

        field[y][x] = 2;
        //  Ship with size 1. Killed
        if (!vertical && !horizontal) {
            return 1;
        }

        boolean have_alive_parts = false;

        if (vertical) {
            for (int down = y; down < 10; ++down) {
                if (field[down][x] == 1) {
                    return 0;
                }
                if (field[down][x] == 0) {
                    break;
                }
            }

            for (int up = y; up >= 0; --up) {
                if (field[up][x] == 1) {
                    return 0;
                }
                if (field[up][x] == 0) {
                    break;
                }
            }
        }

        if (horizontal) {
            for (int right = x; right < 10; ++right) {
                if (field[y][right] == 1) {
                    return 0;
                }
                if (field[y][right] == 0) {
                    break;
                }
            }

            for (int left = x; left >= 0; --left) {
                if (field[y][left] == 1) {
                    return 0;
                }
                if (field[y][left] == 0) {
                    break;
                }
            }
        }
        return 1;
    }

    public Model() {
        System.out.println("Generated field for first player");
        this.first_player_fields[0] = GenerateRandomField();
        System.out.println("Generated field for second player");
        this.second_player_fields[0] = GenerateRandomField();
    }
}
