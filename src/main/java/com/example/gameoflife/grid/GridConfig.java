package com.example.gameoflife.grid;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GridConfig {
    private int[][] grid = new int[20][20];

}
