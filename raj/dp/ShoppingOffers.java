package com.raj.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Raj
 * 
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.

However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.

You could use any of special offers as many times as you want.

Example 1:
Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
Output: 14
Explanation: 
There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
Example 2:
Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
Output: 11
Explanation: 
The price of A is $2, and $3 for B, $4 for C. 
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C. 
You cannot add more items, though only $9 for 2A ,2B and 1C.
 */
public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map <List<Integer> ,Integer> map = new HashMap<>();
        return shoppingOffersUtil(map, price, special, needs);
    }
    
    public int shoppingOffersUtil(Map <List<Integer> ,Integer> map ,List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        if(map.containsKey(needs)){
            return map.get(needs);
        }
        int res = dot(price,needs);
        for(List<Integer> s:special){
            boolean canWeUseThisOffer=true;
            List<Integer> balance_needs = new ArrayList<>();
            
            for(int i=0;i<needs.size();i++){
                if(s.get(i)>needs.get(i)){
                    canWeUseThisOffer = false;
                    break;
                }
                balance_needs.add(needs.get(i)-s.get(i));
            }
            if(canWeUseThisOffer){
                res = Math.min(res, s.get(s.size()-1)+shoppingOffersUtil(map, price, special, balance_needs));
            }
        }
        map.put(needs, res);
        return res;
    }
    
    public int dot(List<Integer> price, List<Integer> needs){
        int total=0;
        for(int i=0;i<price.size();i++){
            total+=(price.get(i)*needs.get(i));
        }
        return total;
    }

    public static void main(String... args) {
        ShoppingOffers obj = new ShoppingOffers();
        int final_price = -1;
        Integer[] price1 = {2, 5 };
        Integer[] needs1 = {3, 2 };
        List<List<Integer>> special1 = new ArrayList<>();
        Integer offer1[] = {3, 0, 5 };
        Integer offer2[] = {1, 2, 10 };
        special1.add(new ArrayList<>(Arrays.asList(offer1)));
        special1.add(new ArrayList<>(Arrays.asList(offer2)));

        final_price = obj.shoppingOffers(new ArrayList<>(Arrays.asList(price1)), special1,
                new ArrayList<>(Arrays.asList(needs1)));
        System.out.println(final_price);
        
        Integer[] price2 = {2,3,4};
        Integer[] needs2 = {1,2,1 };
        List<List<Integer>> special2 = new ArrayList<>();
        Integer offer3[] = {1,1,0,4 };
        Integer offer4[] = {2,2,1,9 };
        special2.add(new ArrayList<>(Arrays.asList(offer3)));
        special2.add(new ArrayList<>(Arrays.asList(offer4)));

        final_price = obj.shoppingOffers(new ArrayList<>(Arrays.asList(price2)), special2,
                new ArrayList<>(Arrays.asList(needs2)));
        System.out.println(final_price);
    }

}