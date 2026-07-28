class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();

        for(int card : hand){
            cardCounts.put(card, cardCounts.getOrDefault(card, 0)+1);
        }

        while(!cardCounts.isEmpty()){

            int first = cardCounts.firstKey();

            for(int i = 0; i < groupSize; i++){
                int currentCard = first + i;
                if(!cardCounts.containsKey(currentCard)){
                    return false;
                }

                int count = cardCounts.get(currentCard);
                if(count == 1){
                    cardCounts.remove(currentCard);
                }
                else{
                    cardCounts.put(currentCard, count - 1);
                }
            }
        }
        return true;
    }
}