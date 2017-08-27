/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interview.onion;

import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author raj
 */
public class Shifting {

	// Number of crates in old warehouse
	int N;
	// List of all that crates in old ware house
	List<Crate> crateLocation = new ArrayList<Crate>();

	public static void main(String args[]) {
		Shifting obj = new Shifting();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the total number of crates in the old warehouse:");
		obj.N = in.nextInt();
		System.out.println("Enter the loction of each crate in x nad y cords:");
		int x = 0;
		int y = 0;

		for (int i = 0; i < obj.N; i++) {
			System.out.println("Enter the x-cord of crate " + (i + 1));
			x = in.nextInt();
			System.out.println("Enter the y-cord of crate " + (i + 1));
			y = in.nextInt();

			Crate c = new Crate(x, y);
			obj.crateLocation.add(c);
		}

		System.out.println("Enter the number of crates to be moved:");
		int M = in.nextInt();

		MoveCrates mobj = new MoveCrates();
		if (mobj.moveToNew(obj.N, obj.crateLocation, M) != null) {
			System.out.println("The following crates will be moved:");
			System.out.println(mobj.movedCrates);
		}
	}
}

class MoveCrates {
	List<Crate> movedCrates = new ArrayList<Crate>();

	public List<Crate> moveToNew(int N, List<Crate> cratesToMove, int M) {

		if (M <= N) {
			Collections.sort(cratesToMove,
					(crate1, crate2) -> (int) (sqrt((crate1.getxCord() * crate1.getxCord())
							+ (crate1.getyCord() * crate1.getyCord())))
					- (int) (sqrt((crate2.getxCord() * crate2.getxCord()) + (crate2.getyCord() * crate2.getyCord()))));

			for (int i = 0; i < M; i++) {
				movedCrates.add(cratesToMove.get(i));
			}

			return movedCrates;
		} else {
			System.out.println("Oops, old WareHouse do not have " + M + "crates");
			return null;
		}
	}
}

class Crate {
	int xCord;
	int yCord;

	public Crate(int xCord, int yCord) {
		super();
		this.xCord = xCord;
		this.yCord = yCord;
	}

	public int getxCord() {
		return xCord;
	}

	public int getyCord() {
		return yCord;
	}

	@Override
	public String toString() {
		return "\nCrate  : [x-Cord: " + xCord + ", y-Cord: " + yCord + "]";
	}
}
