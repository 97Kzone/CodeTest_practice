import java.util.HashMap;

class UserSolution {

    static class Info {
        int x, y;
        boolean flag;

        Info(int x, int y) {
            this.x = x;
            this.y = y;
            flag = false;
        }
    }
    
    HashMap<Integer, Info> infoMap = new HashMap<>(); // pID, Info클래스
    HashMap<Integer, Integer> pointMap = new HashMap<>(); // 좌표, pID
    HashMap<Integer, int[]> visitMap = new HashMap<>(); // uID, 방문 pid
    static int[] moves = {-10000, -9999, 1, 10001, 10000, 9999, -1, -10001};

	void init() {
        infoMap.clear();
        pointMap.clear();
        visitMap.clear();
	}

	void addPlace(int pID, int r, int c) {
        Info info = new Info(r, c);
        infoMap.put(pID, info);
        pointMap.put(10000*r + c, pID);
	}

	void removePlace(int pID) {
        Info info = infoMap.get(pID);
        
        infoMap.remove(pID);
        pointMap.remove(10000 * info.x + info.y); 
	}

	void contactTracing(int uID, int visitNum, int moveInfo[], int visitList[]) {
        int pID = moveInfo[0];
        Info info = infoMap.get(pID);
        visitList[0] = pID; // 방문
        int point = 10000 * info.x + info.y;

        // 목적지를 찾아 떠나자
        int idx = 1;
        int move, nxt;
        Info nxtInfo;
        for (int i = 1; i < visitNum; i++) {
            move = moves[moveInfo[i]];

            while(true) {
                point += move;
                if (!pointMap.containsKey(point)) continue;

                nxt = pointMap.get(point);
                nxtInfo = infoMap.get(nxt);

                if (nxtInfo.flag) continue; // 이미 감염된 곳은 넘어간다

                // nxtInfo.flag = true;
                visitList[idx++] = nxt;
                break;
            }
        }
        int[] visit = new int[visitNum];
        for (int i = 0; i < visitNum; i++) {
            visit[i] = visitList[i];
            infoMap.get(visit[i]).flag = true;
        }
        visitMap.put(uID, visit); // uID가 방문한 곳 처리
	}

	void disinfectPlaces(int uID) {
        int[] visit = visitMap.get(uID);
        for (int pID : visit) {
            if (!infoMap.containsKey(pID)) continue; 
            infoMap.get(pID).flag = false;
        }
    }
}