package com.mehmetpekcan.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  // Constants
  static final String FIRST_PLAYER = "X";
  static final String SECOND_PLAYER = "O";

  // to determine turn of player
  boolean firstPlayerTurn =  true;

  // to keep round count
  static int roundCount = 1;

  // to keep game board
  byte[][] board = new byte[3][3];

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TableLayout table = findViewById(R.id.board);

    for (int i = 0; i < 3; i++) {
      TableRow row = (TableRow) table.getChildAt(i);

      for (int j = 0; j < 3; j++) {
        Button btn = (Button) row.getChildAt(j);
        btn.setOnClickListener(new CellListener(i, j));
      }
    }

  }

  public boolean checkGameStatus() {
    // checking for rows
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
          return true;
        }
      }
    }

    // checking for columns
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
          return true;
        }
      }
    }

    // checking for diagonals
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
      return true;
    }

    if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
      return true;
    }

    return false;
  }

  public boolean isValidMove(int row, int col) {
    return board[row][col] == 0;
  }

  class CellListener implements View.OnClickListener {
    int row, col;

    public CellListener(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public void onClick(View v) {
      if (!isValidMove(row, col)) {
        return;
      }

      Button cell = (Button) v;

      if (firstPlayerTurn) {
        cell.setText(FIRST_PLAYER);
        board[row][col] = 1;
      } else {
        cell.setText(SECOND_PLAYER);
        board[row][col] = 2;
      }

      roundCount++;

      if (checkGameStatus()) {
        if (firstPlayerTurn) {
          Toast.makeText(MainActivity.this, "First player win", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(MainActivity.this, "Second player win", Toast.LENGTH_SHORT).show();
        }
      } else if (roundCount == 10) {
        Toast.makeText(MainActivity.this, "Draw", Toast.LENGTH_SHORT).show();
      } else {
        firstPlayerTurn = !firstPlayerTurn;
      }
    }
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);

    byte[] boardSingle = new byte[9];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) { boardSingle[3 * i + j] = board[i][j];
      }
    }

    outState.putByteArray("board", boardSingle);
    outState.putBoolean("firstPlayerTurn", firstPlayerTurn);
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

    firstPlayerTurn = savedInstanceState.getBoolean("firstPlayerTurn");

    byte[] boardSingle = savedInstanceState.getByteArray("board");

    for (int i = 0; i < 9; i++) {
      board[i / 3][i % 3] = boardSingle[i];
    }

    TableLayout table = findViewById(R.id.board);

    for (int i = 0; i < 3; i++) {
      TableRow row = (TableRow) table.getChildAt(i);

      for (int j = 0; j < 3; j++) {
        Button btn = (Button) row.getChildAt(j);
        btn.setText(board[i][j] == 1 ? "X" : board[i][j] == 2 ? "O" : "");
      }
    }
  }
}