package io.kanthis;

import static io.kanthis.WinDriverCommand.*;

import java.util.Map;

import org.openqa.selenium.remote.codec.w3c.W3CHttpCommandCodec;

public class WinDriverCommandCodec extends W3CHttpCommandCodec {

    public WinDriverCommandCodec() {
        //  Base W3C
        String sessionId = "/session/:sessionId";
        defineCommand(GET_PAGE_SOURCE, get(sessionId + "/source"));
        defineCommand(ACTIONS, post(sessionId + "/actions"));
        defineCommand(CLEAR_ACTIONS_STATE, delete(sessionId + "/actions"));

        String elementId = sessionId + "/element/:id";
        defineCommand(GET_ELEMENT_ATTRIBUTE, get(elementId + "/attribute/:name"));
        defineCommand(IS_ELEMENT_DISPLAYED, get(elementId + "/displayed"));
        
        String window = sessionId + "/window";
        defineCommand(GET_WINDOW_HANDLES, get(window + "/handles"));
        defineCommand(GET_CURRENT_WINDOW_HANDLE, get(window));
        defineCommand(GET_CURRENT_WINDOW_POSITION, get(window + "/rect"));
        defineCommand(SET_CURRENT_WINDOW_POSITION, post(window + "/rect"));
        defineCommand(GET_CURRENT_WINDOW_SIZE, get(window + "/rect"));
        defineCommand(SET_CURRENT_WINDOW_SIZE, post(window + "/rect"));
        defineCommand(MAXIMIZE_CURRENT_WINDOW, post(window + "/maximize"));
        defineCommand(MINIMIZE_CURRENT_WINDOW, post(window + "/minimize"));

        defineCommand(GET_ACTIVE_ELEMENT, get(sessionId + "/element/active"));

        //  Element pattern
        String annotationPattern = sessionId + "/annotationPattern/:id";
        defineCommand(GET_ANNOTATION_TARGET, get(annotationPattern + "/target"));

        String basePattern = sessionId + "/basePattern/:id";
        defineCommand(GET_LABELED_BY, get(basePattern + "/labeledBy"));
        defineCommand(GET_CONTROLLER_FOR, get(basePattern + "/controllerFor"));
        defineCommand(GET_DESCRIBED_BY, get(basePattern + "/describedBy"));
        defineCommand(GET_FLOWS_TO, get(basePattern + "/flowsTo"));
        defineCommand(FOCUS, post(basePattern + "/focus"));

        String customNavigationPattern = sessionId + "/customNavigationPattern/:id";
        defineCommand(NAVIGATE_DIRECTION, post(customNavigationPattern + "/navigate"));

        String dockPattern = sessionId + "/dockPattern/:id";
        defineCommand(SET_DOCK_POSITION, post(dockPattern + "/position"));

        String dragPattern = sessionId + "/dragPattern/:id";
        defineCommand(GET_DROP_EFFECTS, get(dragPattern + "/dropEffects"));
        defineCommand(GET_GRABBED_ITEMS, get(dragPattern + "/grabbedItems"));

        String dropTargetPattern = sessionId + "/dropTargetPattern/:id";
        defineCommand(GET_DROP_TARGET_EFFECTS, get(dropTargetPattern + "/dropTargetEffects"));

        String expandCollapsePattern = sessionId + "/expandCollapsePattern/:id";
        defineCommand(EXPAND_COLLAPSE, post(expandCollapsePattern + "/expandCollapse"));

        String gridItemPattern = sessionId + "/gridItemPattern/:id";
        defineCommand(GET_CONTAINING_GRID, get(gridItemPattern + "/containingGrid"));

        String gridPattern = sessionId + "/gridPattern/:id";
        defineCommand(GET_GRID_ITEM, post(gridPattern + "/item"));

        String invokePattern = sessionId + "/invokePattern/:id";
        defineCommand(INVOKE, post(invokePattern + "/invoke"));

        String multipleViewPattern = sessionId + "/multipleViewPattern/:id";
        defineCommand(GET_SUPPORTED_VIEWS, get(multipleViewPattern + "/supportedViews"));
        defineCommand(GET_VIEW_NAME, get(multipleViewPattern + "/viewName/:viewId"));
        defineCommand(SET_CURRENT_VIEW, post(multipleViewPattern + "/currentView"));

        String rangeValuePattern = sessionId + "/rangeValuePattern/:id";
        defineCommand(SET_RANGE_VALUE, post(rangeValuePattern + "/value"));

        String scrollItemPattern = sessionId + "/scrollItemPattern/:id";
        defineCommand(SCROLL_INTO_VIEW, post(scrollItemPattern + "/scrollIntoView"));

        String scrollPattern = sessionId + "/scrollPattern/:id";
        defineCommand(SCROLL, post(scrollPattern + "/scroll"));
        defineCommand(SET_SCROLL_PERCENT, post(scrollPattern + "/scrollPercent"));

        String selectionItemPattern = sessionId + "/selectionItemPattern/:id";
        defineCommand(SELECT, post(selectionItemPattern + "/select"));
        defineCommand(ADD_SELECTION, post(selectionItemPattern + "/selection"));
        defineCommand(REMOVE_SELECTION, delete(selectionItemPattern + "/selection"));
        defineCommand(GET_SELECTION_CONTAINER, get(selectionItemPattern + "/selectionContainer"));

        String selectionPattern2 = sessionId + "/selectionPattern2/:id";
        defineCommand(GET_FIRST_SELECTED, get(selectionPattern2 + "/firstSelected"));
        defineCommand(GET_LAST_SELECTED, get(selectionPattern2 + "/lastSelected"));
        defineCommand(GET_CURR_SELECTED, get(selectionPattern2 + "/currentSelected"));

        String spreadSheetItemPattern = sessionId + "/spreadSheetItemPattern/:id";
        defineCommand(ANNOTATION_OBJECTS, get(spreadSheetItemPattern + "/annotationObjects"));

        String spreadSheetPattern = sessionId + "/spreadSheetPattern/:id";
        defineCommand(GET_SPREADSHEET_ITEM, get(spreadSheetPattern + "/item/:name"));

        String tableItemPattern = sessionId + "/tableItemPattern/:id";
        defineCommand(GET_ROW_HEADER_ITEMS, get(tableItemPattern + "/rowHeaderItems"));
        defineCommand(GET_COLUMN_HEADER_ITEMS, get(tableItemPattern + "/columnHeaderItems"));

        String tablePattern = sessionId + "/tablePattern/:id";
        defineCommand(GET_ROW_HEADERS, get(tablePattern + "/rowHeaders"));
        defineCommand(GET_COLUMN_HEADERS, get(tablePattern + "/columnHeaders"));

        String togglePattern = sessionId + "/togglePattern/:id";
        defineCommand(TOGGLE, post(togglePattern + "/toggle"));

        String transformPattern2 = sessionId + "/transformPattern2/:id";
        defineCommand(ZOOM, post(transformPattern2 + "/zoom"));
        defineCommand(ZOOM_BY_UNIT, post(transformPattern2 + "/zoomByUnit"));
        defineCommand(MOVE, post(transformPattern2 + "/move"));
        defineCommand(RESIZE, post(transformPattern2 + "/resize"));
        defineCommand(ROTATE, post(transformPattern2 + "/rotate"));

        String valuePattern = sessionId + "/valuePattern/:id";
        defineCommand(SET_VALUE, post(valuePattern + "/value"));

        String virtualizedItemPattern = sessionId + "/virtualizedItemPattern/:id";
        defineCommand(REALIZE, post(virtualizedItemPattern + "/realize"));

        String windowPattern = sessionId + "/windowPattern/:id";
        defineCommand(SET_VISUAL_STATE, post(windowPattern + "/visualState"));
        defineCommand(WAIT_INPUT_IDLE, post(windowPattern + "/waitForInputIdle"));
        defineCommand(CLOSE_WINDOW, delete(windowPattern));
        defineCommand(GET_WINDOW_RECT, get(windowPattern + "/rect"));
        defineCommand(BRING_ON_TOP, post(windowPattern + "/bringToTop"));
        defineCommand(SET_WINDOW_RECT, post(windowPattern + "/rect"));
    }

    @Override
    public void alias(String commandName, String isAnAliasFor) {}

    @Override
    protected Map<String, ?> amendParameters(String name, Map<String, ?> parameters) {
        switch (name) {
            case SEND_KEYS_TO_ELEMENT:
                return super.amendParameters(name, parameters);
            default:
                break;
        }
        return parameters;
    }
}
