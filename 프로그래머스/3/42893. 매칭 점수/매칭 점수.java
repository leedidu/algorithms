import java.util.*;
import java.util.regex.*;

class Web {
    String content;
    String body;
    List<String> hrefs;
    double basicScore; // 기본점수
    int externalLinkCount; // 외부링크수
    double linkScore; // 링크점수
    double matchingScore; // 매칭점수

    public Web(String content, String body, List<String> hrefs) {
        this.content = content;
        this.body = body;
        this.hrefs = hrefs;
    }

    public String getContent() {
        return content;
    }

    public String getBody() {
        return body;
    }

    public List<String> getHrefs() {
        return hrefs;
    }

    public double getBasicScore() {
        return basicScore;
    }

    public void setBasicScore(double basicScore) {
        this.basicScore = basicScore;
    }

    public int getExternalLinkCount() {
        return externalLinkCount;
    }

    public void setExternalLinkCount(int externalLinkCount) {
        this.externalLinkCount = externalLinkCount;
    }

    public double getLinkScore() {
        return linkScore;
    }

    public void setLinkScore(double linkScore) {
        this.linkScore = linkScore;
    }

    public double getMatchingScore() {
        return matchingScore;
    }

    public void setMatchingScore(double matchingScore) {
        this.matchingScore = matchingScore;
    }
}

class Solution {
    static List<Web> webs;
    static String compareWord;

    public static int solution(String word, String[] pages) {
        webs = new ArrayList<>();
        compareWord = word.toLowerCase();

        // 전처리 >> body, content, href
        for (String page : pages) {
            String content = "";
            String body = page.replaceAll("(?s).*<body.*?>(.*?)</body>.*", "$1")
                    .replaceAll("<[^>]+>", " ") // 태그 제거
                    .trim(); // 양쪽 공백 제거
            List<String> hrefs = new ArrayList<>();

            // <meta> 태그에서 URL 추출
            Matcher contentMatcher = Pattern.compile("meta property=\"og:url\" content=\"(.*?)\"").matcher(page);
            if (contentMatcher.find()) {
                content = contentMatcher.group(1).trim();
            } else{
                content = "";
            }

            // href 태그 추출
            Matcher hrefMatcher = Pattern.compile("<a[^>]*?href=\"(.*?)\"").matcher(page);
            while (hrefMatcher.find()) {
                hrefs.add(hrefMatcher.group(1));
            }

            Web web = new Web(content, body, hrefs);
            webs.add(web);
        }

        countBasicScore();
        countExternalLinkScore();
        countLinkScore();
        countMatchingScore();

        return findMaxIndex();
    }

    // 기본 점수 메서드
    public static void countBasicScore() {
        for (Web web : webs) {
            String body = web.getBody().toLowerCase();
            String cleanedBody = body.replaceAll("[^a-zA-Z\\s]", " ").toLowerCase().trim();
            String[] words = cleanedBody.split("\\s+");

            for (String w : words) {
                if (w.equals(compareWord)) {
                    web.basicScore++;
                }
            }
        }
    }

    // 외부링크 개수 카운트
    public static void countExternalLinkScore() {
        for (Web web : webs) {
            List<String> listHref = web.getHrefs();
            web.setExternalLinkCount(listHref.size());
        }
    }

    // 링크점수
    public static void countLinkScore() {
        for (int i = 0; i < webs.size(); i++) { // 설정할 웹
            for (int j = 0; j < webs.size(); j++) { // 나머지 웹
                if (i != j) {
                    List<String> listHref = webs.get(j).getHrefs();
                    if (listHref.contains(webs.get(i).getContent()) && webs.get(j).getExternalLinkCount() > 0) {
                        webs.get(i).linkScore += (webs.get(j).getBasicScore() / webs.get(j).getExternalLinkCount());
                    }
                }
            }
        }
    }

    // 매칭점수 카운트
    public static void countMatchingScore() {
        for (Web web : webs) {
            web.setMatchingScore(web.getBasicScore() + web.getLinkScore());
        }
    }

    // 매칭점수 비교해서 가장 큰 인덱스 찾는 메서드
    public static int findMaxIndex() {
        double max = -1;
        int idx = -1;
        for (int i = 0; i < webs.size(); i++) {
            if (webs.get(i).getMatchingScore() > max ||
                    (webs.get(i).getMatchingScore() == max && i < idx)) {
                max = webs.get(i).getMatchingScore();
                idx = i;
            }
        }
        return idx;
    }
}
